package com.prakruthi.ui;

public class Variables {

    //    public static String BaseUrl = "https://houseofspiritshyd.in/prakruthi/admin/api/";
    public static String BaseUrl = "http://prakruthiepl.com/admin/api/";
    //public static String BaseUrl = "https://prakruthiepl.com/admin/api";


    public static String companyBaseUrl = "http://prakruthiepl.com/admin/api";
//public static String companyBaseUrl = "https://prakruthiepl.com/admin/api";


    public static final String USER_NAME = "User_Name";

    public static final String USER_EMAIL = "User_Email";

    public static final String USER_MOBILE = "mobile";


    //AddReview:--

    public static String rating;
    public static String review;

    public static String description;

    //Login
    public static String token;
    //    public static Integer id;
//    public static Integer departmentId;
    public static Integer id;
    public static Integer departmentId;
//    public static Integer departmentId = 1;
//    public static Integer departmentId = Integer.valueOf("1");

    public static String userCode;
    public static String name;

    public static String lastName;
    public static String email;

    public static String password;

    public static String mobile;

    public static String gender;

    public static String dob;
    public static String attachment;
    public static String city;

    public static String postCode;
    public static String address;
    public static String addressID;
    public static String state;

    public static String country;

    public static String district;

    public static String street;

    public static String about;

    public static String status;

    public static String mobileVerified;

    public static String isVerified;

    public static String logDateCreated;

    public static String createdBy;

    public static String logDateModified;

    public static String modifiedBy;

    public static String fcmToken;

    public static String deviceId;
    public static String allowEmail;
    public static String allowSms;
    public static String allowPush;

    public static String status_code;
    public static String privacyPolicy;
    public static String termsAndConditions;
    public static String returnRefundPolicy;
    public static String security;
    public static String aboutUs;
    public static String loggedIn;

    public static String message;

    public static String base_path;



    //Registration:-----
//    public static Integer userId;
    public static String userId;
//    public static Integer userId = 1;
//    public static Integer userId = Integer.valueOf("1");

    public static String userMobile;

    public static String apiToken;

    public static String RegistrationOTP;

    public static String phoneNumber;

    public static String productId;

    public static String invoice_id;

    public static String invoice_num;


//    public static String invoiceId;

    //-------
    public static String quntity;

    public static String remaining_quntity;

    public static String updateData;

    public static String Order_No;
    public static String Amount;

    public static String support_mobile;
    public static String support_email;
    public static String support_address;

    //    public static String department_name;
    public static String departmentName;

    public static String postalCode;

//        public static Boolean isDefault;
    public static int isDefault;

//    public static boolean isDefault;



//    isDefault


    public static void clear() {


        description = "";

        support_mobile = "";
        support_email = "";
        support_address = "";

        privacyPolicy = "";
        termsAndConditions = "";
        termsAndConditions = "";
        returnRefundPolicy = "";
        security = "";
        aboutUs = "";
        message = "";
        // Login:----
        token = "";
        id = null;
        departmentId = null;
        userCode = "";
        name = "";
        lastName = "";
        email = "";
        password = "";
        mobile = "";
        gender = "";
        dob = "";
        attachment = "";
        city = "";
        postCode = "";
        address = "";
        state = "";
        country = "";
        district = "";
        street = "";
        about = "";
        status = "";
        mobileVerified = "";
        isVerified = "";
        logDateCreated = "";
        createdBy = "";
        logDateModified = "";
        modifiedBy = "";
        fcmToken = "";
        deviceId = "";
        allowEmail = "";
        allowSms = "";
        allowPush = "";

        status_code = "";
        loggedIn = "";
        message = "";

        // Registration
        userId = null;
        userMobile = "";
        apiToken = "";
        RegistrationOTP = "";
        phoneNumber = "";


        invoice_id = "";
//        invoiceId="";

        invoice_num = "";

        productId = "";


        rating = "";
        review = "";


        //Get/Save OrderPurchaseQuantityQtyData
        remaining_quntity = "";
        quntity = "";

        updateData = "";

        Order_No = "";
        Amount = "";

//        invoice_num="";


//        department_name="";
        departmentName = "";

        postalCode = "";

//        isDefault = true;
        isDefault =1;

        base_path ="";

    }

}
