pipeline {
    agent {
        label "${testingSlave}"
    }

    options {
        skipDefaultCheckout true
    }

    stages {
        stage('CleanWorkspace') {
            steps { cleanWs() }
        }

        stage('Clone Project') {
            steps {
                script {
                    git branch: "${branchName}",
                            credentialsId: '7b6d439f-1c79-416a-9192-eede38b0af48',
                            url: 'git@git.vf-eg.internal.vodafone.com:sales-digital-frameworks/eshop_automation.git'
                }
            }
        }

        stage('Run on Testing') {
            when {
                expression {
                    environment == 'Testing'
                }
            }
            steps {
                script {
                    wrap([$class: 'BuildUser']) {
                        echo "${BUILD_USER_ID}"
                        bat """
                             set http_proxy=http://10.230.189.34:3128
                             set https_proxy=http://10.230.189.34:3128
                             mvn -DENVIRONMENT=${environment} -DBROWSERNAME=${BrowserName} clean test
                        """
                    }
                }
            }
        }

        stage('Run on Staging') {
            when {
                expression {
                    environment == 'Staging'
                }
            }
            steps {
                script {
                    wrap([$class: 'BuildUser']) {
                        echo "${BUILD_USER_ID}"
                        bat """
                             set http_proxy=http://10.230.189.34:3128
                             set https_proxy=http://10.230.189.34:3128
                             mvn -DENVIRONMENT=${environment} -DBROWSERNAME=${BrowserName} clean test
                        """
                    }
                }
            }
        }

        stage('Run on Production') {
            when {
                expression {
                    environment == 'Production'
                }
            }
            steps {
                script {
                    wrap([$class: 'BuildUser']) {
                        echo "${BUILD_USER_ID}"
                        bat """
                             set http_proxy=http://10.230.189.34:3128
                             set https_proxy=http://10.230.189.34:3128
                             mvn -DENVIRONMENT=${environment} -DBROWSERNAME=${BrowserName} clean test
                        """
                    }
                }
            }
        }
    }

    post {
        success {
            script {
                // Generate Allure Report
                allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                ])

                bat """
                    allure generate allure-results --single-file -o reports/EshopAllureReport
                """

                // Rename Allure report index.html to EshopAllureReport.html
                bat '''
                    if exist reports\\EshopAllureReport\\index.html (
                        copy reports\\EshopAllureReport\\index.html EshopAllureReport.html
                    )
                '''

                // Copy and rename Extent report
                bat '''
                    if exist resources\\reports\\EshopAutomationReport.html (
                        copy resources\\reports\\EshopAutomationReport.html EshopExtentReport.html
                    )
                '''

                // Archive individual HTML reports
                archiveArtifacts artifacts: 'EshopAllureReport.html', fingerprint: true
                archiveArtifacts artifacts: 'EshopExtentReport.html', fingerprint: true

                // Send success email with both reports attached
                emailext attachLog: true,
                        attachmentsPattern: 'EshopAllureReport.html,EshopExtentReport.html',
                        body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}<br>" +
                                "More info at: ${env.BUILD_URL}<br>" +
                                "Allure Report: ${env.BUILD_URL}allure/",
                        to: "${Email}",
                        subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}",
                        mimeType: 'text/html'

                // Cleanup
                bat 'del /Q /S reports\\*.*'
                bat 'del /Q EshopAllureReport.html EshopExtentReport.html'
            }
        }

        failure {
            script {
                // Generate Allure Report
                allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                ])

                bat """
                    allure generate allure-results --single-file -o reports/EshopAllureReport
                """

                // Copy and rename Extent report on failure
                bat '''
                    if exist resources\\reports\\EshopAutomationReport.html (
                        copy resources\\reports\\EshopAutomationReport.html EshopExtentReport.html
                    )
                '''

                archiveArtifacts artifacts: 'EshopExtentReport.html', fingerprint: true
                archiveArtifacts artifacts: 'EshopAllureReport.html', fingerprint: true

                emailext attachLog: true,
                        attachmentsPattern: 'EshopExtentReport.html,EshopAllureReport.html',
                        body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}<br>" +
                                "More info at: ${env.BUILD_URL}",
                        to: "${Email}",
                        subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}",
                        mimeType: 'text/html'

                // Cleanup
                bat 'del /Q /S reports\\*.*'
                bat 'del /Q EshopExtentReport.html EshopAllureReport.html'
            }
        }
    }
}
