package com.vodafone.vodafone_eshop_taf.platform;

import com.vodafone.vodafone_eshop_taf.pages.*;

public class EshopWebsite extends PageBase {

    public Home home;
    public ProductDetails productDetails;
    public Cart cart;
    public Checkout checkout;
    public RedLines redLines;
    public RedLinesPlans redLinesPlans;
    public RedLinesSummary redLinesSummary;
    public Mnp mnp;
    public Dsl dsl;
    public Login login;
    public Header header;
    public com.vodafone.vodafone_eshop_taf.pages.Search Search;
    public ProductsList productsList;
    public PersonalDetails personalDetails;
    public MyOrders myOrders;
    public FlexLines flexLines ;
    public FlexLinesPlans flexLinesPlans;
    public FlexLinesSummary flexLinesSummary;
    public AtHomeBundle atHomeBundle;
    public AtHomeRouter atHomeRouter;
    public AtHomeSubscriptionDetails atHomeSubscriptionDetails;
    public Vouchers vouchers;
    public Addresses addresses;
    public Payment payment;
    public OrderConfirmation orderConfirmation;
    public PaymentContent paymentContent;
    public PaymentDetails paymentDetails;
    public OrderDetails orderDetails;



    public EshopWebsite() {
        home = new Home();
        dsl=new Dsl();
        header = new Header();
        productsList=new ProductsList();
        Search = new Search();
        redLines = new RedLines();
        redLinesPlans = new RedLinesPlans();
        redLinesSummary = new RedLinesSummary();
        personalDetails = new PersonalDetails();
        myOrders = new MyOrders ();
        flexLines = new FlexLines();
        flexLinesPlans = new FlexLinesPlans();
        flexLinesSummary = new FlexLinesSummary();
        vouchers = new Vouchers();
        payment = new Payment();
        orderConfirmation = new OrderConfirmation();
        orderDetails = new OrderDetails();
    }
}
