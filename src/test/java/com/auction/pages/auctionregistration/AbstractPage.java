package com.auction.pages.auctionregistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public abstract class AbstractPage extends SeleniumInit {

	protected Common common = new Common(driver);

	ConfigFileReader configFileReader = new ConfigFileReader();
	String uname = "bid";
	String password = "path";
	String customFiled1 = common.generateRandomChars(5);

	public int DRIVER_WAIT = 5;
	protected String TEST_ENVIRONMENT = configFileReader.getFrontUrl();
	protected String ADMIN_TEST_ENVIRONMENT = configFileReader.getAdminUrl();
	
	protected String testURl = TEST_ENVIRONMENT;
	protected String admintestUrl = ADMIN_TEST_ENVIRONMENT;
	
	

	protected String TEST_ENVIRONMENT1 = configFileReader.getdevUrl();
	protected String ADMIN_TEST_ENVIRONMENT2 = configFileReader.getdev_auctionUrl();
	
	protected String TEST_ENVIRONMENT_NEW = configFileReader.getqa_dev_autofrontendUrl();
	protected String DevAuctoFrontendURL = TEST_ENVIRONMENT_NEW;

	// Login Constant Elements

	// public String LEGACY_ADMIN_SIGNIN_TXT_URL_Dev = configFileReader.getdevUrl();
	public String LEGACY_ADMIN_SIGNIN_TXT_URL = configFileReader.getFrontUrl();
	public String LEGACY_ADMIN_SIGNIN_TXT_URL_ADMIN = configFileReader.getAdminUrl();
	public String LEGACY_ADMIN_SIGNIN_TXT_USERNAME = "usr";
	public String LEGACY_ADMIN_SIGNIN_TXT_PASSWORD = "pas";
	public String LEGACY_ADMIN_LOGIN_BUTTON = "lgn";
	public String LEGACY_FRONT_LOGIN_TXT_USERNAME = "usr";
	public String LEGACY_FRONT_LOGIN_TXT_USERNAME1 = "Username";
	public String LEGACY_FRONT_LOGIN_TXT_PASSWORD = "pas";
	public String LEGACY_FRONT_LOGIN_BTN = "Login";
	public String LEGACY_FRONT_BUY_QUANTITY = "buy-now-qty-input";
	public String LEGACY_FRONT_AUCTIONLIST_BUTTON = "unibtn auclistbtn";
	public String LEGACY_FRONT_PENDING_APPROVAL ="Pending approval";
	public String LEGACY_FRONT_BUYNOW_BUTTON = "Buy now!";
	public String LEGACY_FRONT_BID_BUTTON = "Bid $100";
	public String LEGACY_FRONT_CLICK_BUTTON = "qbutton-ctl";
	public String LEGACY_FRONT_CONFIRM_BUTTON = "Confirm";
	public String LEGACY_FRONT_BIDDINGNOW_UPCOMING = "alf1_ctl";
	public String LEGACY_FRONT_BUTTON = "button";
	public String LEGACY_FRONT_PLACE_BID = "textbox timed-maxbid";
	public String LEGACY_FRONT_TXT_BIDDINGNOW_AND_UPCOMING = "Bidding now and upcoming";
	public String LEGACY_FRONT_SALE_SELECT_DROPDOWN = "ui-menu-item";
	public String LEGACY_FRONT_SELECT_UPCOMING_ONLY = "Upcoming only";
	public String LEGACY_FRONT_LOGIN_LBL_USERNAME = "Username";
	public String LEGACY_FRONT_LOGIN_LBL_USERNAME1 = "iodvy";
	public String LEGACY_FRONT_LOGIN_LBL_PASSWORD = "Password";
	public String LEGACY_FRONT_LOGIN_LBL_NOT_A_MEMBER_YET = "Not a member yet?";
	public String LEGACY_FRONT_LOGIN_LBL_NOT_REGISTER_NOW = "Register now!";
	public String LEGACY_FRONT_LOGIN_LBL_NOT_IT_IS_EASY = "It's easy!";
	public String LEGACY_FRONT_LOGIN_LBL_SIGN_IN = "Sign in";
	public String LEGACY_FRONT_LOGIN_TXT_AUCTIONS = "Auctions";
	public String LEGACY_ADMIN_TXT_WARNING = "warning";
	public String LEGACY_FRONT_LOGIN_TXT_ITEMS = "My Items";
	public String LEGACY_FRONT_LOGIN_MYITEMS_TAB = "main-menu";
	public String LEGACY_FRONT_LOGIN_ITEM_CONSIGNED = "Items consigned";
	public String LEGACY_FRONT_LOGIN_TXT_BIDDING_ON = "Bidding on";
	public String LEGACY_FRONT_LOGIN_TXT_MY_ALERT = "My Alerts";
	public String LEGACY_FRONT_LOGIN_TXT_ALERT = "Alerts";
	public String LEGACY_ADMIN_ALERT_MESSAGE = "alert";
	public String LEGACY_FRONT_LOGIN_TXT_SIGNUP = "Signup";
	public String LEGACY_FRONT_SEARCH_ICON ="listnav";
	public String LEGACY_FRONT_AUCTIONS_BUTTON ="Auctions";
	public String LEGACY_FRONT_LOGIN_TXT_LOGIN = "Login";
	public String LEGACY_FRONT_LOGIN_TXT_FORGOT_PASSWORD = "Forgot password?";
	public String LEGACY_FRONT_LOGIN_TXT_FORGOT_USERNAME = "Forgot username?";
	public String LEGACY_FRONT_LOGIN_BTN_BID = "btnPlaceBid";
	public String LEGACY_FRONT_LOGIN_BTN_CONFIRM_ADD_LOT = "z26";
	public String LEAGACY_FORNT_TXT_INVALID_USERNAME_AND_PASSWORD ="Invalid username or password";

	// Login User Elements
	public String LEGACY_FRONT_LOGIN_TXT_LOGOUT = "Logout";
	public String LEGACY_FRONT_LOGIN_TXT = "Login";

	// Regular SignUp
	public String LEGACY_USER_SIGNUP_TXT_USERNAME = "pip1";
	public String LEGACY_USER_SIGNUP_TXT_USERNAME_VALUE = "rahul";
	public String LEGACY_USER_SIGNUP_TXT_PASSWORD = "pip2";
	public String LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE = "rahul123";
	public String LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD = "pip3";
	public String LEGACY_USER_SIGNUP_TXT_LAST_NAME = "pip5";
	public String LEGACY_USER_SIGNUP_TXT_FIRST_NAME = "pip4";
	public String LEGACY_USER_SIGNUP_TXT_PHONE = "pnpip9";
	public String LEGACY_USER_SIGNUP_TXT_PHONE_VALUE = "7183432012";
	public String LEGACY_USER_SIGNUP_TXT_EMAIL = "pip6";
	public String LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE = "@perfectqaservices.com";
	public String LEGACY_USER_SIGNUP_TXT_IDENTIFICATION = "pip12";
	public String LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE = "H2356370";
	public String LEGACY_USER_SIGNUP_LST_IDENTIFICATION_TYPE = "pip13_ctl";
	public String LEGACY_USER_SIGNUP_LST_IDENTIFICATION_TYPE1 = "pip13";
	public String LEGACY_USER_SIGNUP_LST_USER_ROLE22 = "UsrCustFldEdt524_ctl";
	public String LEGACY_USER_SIGNUP_TXT_COMPANY = "pip10";
	public String LEGACY_USER_SIGNUP_TXT_COMPANY1 = "rbp2";
	public String LEGACY_USER_SIGNUP_TXT_COMPANY_VALUE = "Perfect QA Services";
	public String LEGACY_USER_SIGNUP_TXT_EMAIL_ALREADY_EXISTS = "pip6_ctl";
	public String LEGACY_USER_SIGNUP_TXT_PHONE_TYPE = "pip11_ctl";
	public String LEGACY_USER_SIGNUP_TXT_TOGGLE = "sbToggle";
	public String LEGACY_USER_PHONE_TYPE_WORK = "Work";
	public String LEGACY_USER_IDENTIFICATION_TYPE ="Identification Type";
	public String LEGACY_USER_SIGNUP_TXT_PHONE_TYPE1 = "pip11";
	public String LEGACY_USER_SIGNUP_TXT_FIRST_NAME_REQUIRED = "pip4";
	public String LEGACY_USER_SIGNUP_TXT_LAST_NAME_REQUIRED = "pip5";
	public String LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL = "pip8";
	public String LEGACY_USER_SIGNUP_LINK = "Signup";
	public String LEGACY_TXT_SIGNUP_USERNAME = "label-input label-input-username";
	public String LEGACY_TXT_SIGNUP_PASSWORD = "label-input label-input-password";
	public String LEGACY_TXT_SIGNUP_CONFIRM_PASSWORD = "label-input label-input-confirmpassword";
	public String LEGACY_TXT_SIGNUP_EMAIL = "label-input label-input-email";
	public String LEGACY_TXT_SIGNUP_FIRST_NAME = "label-input label-input-firstname";
	public String LEGACY_TXT_SIGNUP_LAST_NAME = "label-input label-input-lastname";
	public String LEGACY_TXT_SIGNUP_PHONE = "label-input label-input-phone";
	public String LEGACY_TXT_SIGNUP_PHONE_TYPE = "label-input label-input-phonetype";
	public String LEGACY_TXT_SIGNUP_BILL_CONTACT_TYPE = "label-input label-input-billcontacttype";
	public String LEGACY_TXT_SIGNUP_BILL_FIRST_NAME = "label-input label-input-billfirstname";
	public String LEGACY_TXT_SIGNUP_BILL_LAST_NAME = "label-input label-input-billlastname";
	public String LEGACY_TXT_SIGNUP_BILL_PHONE = "label-input label-input-billphone";
	public String LEGACY_TXT_SIGNUP_VALIDATION ="Signup failed.";

	// Regular SignUp Billing information
	
	public String LEGACY_USER_SIGNUP_CC_CODE = "pbcp19";
	public String LEGACY_USER_SIGNUP_BILL_LST_CONTACT_TYPE = "rbp25_ctl";
	public String LEGACY_USER_SIGNUP_BILL_LST_CONTACT_TYPE_ELEMENT_PRESENT = "ccrbp5";
	public String LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME = "rbp3";
	public String LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME = "rbp4";
	public String LEGACY_USER_SIGNUP_BILL_TXT_PHONE = "pnrbp5";
	public String LEGACY_USER_SIGNUP_SELECT_COUNTRY = "rbp7";
	public String LEGACY_USER_SIGNUP_SELECT_STATE = "rbp37";
	public String LEGACY_USER_SIGNUP_BILL_LST_COUNTRY = "rbp7_ctl";
	public String LEGACY_USER_CITY_CANADA = "Canada";
	public String LEGACY_USER_CITY_ALBERTA = "Alberta";
	public String LEGACY_USER_COUNTRY = "rbp37_ctl";
	public String LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS = "rbp8";
	public String LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_WARNING_MESSAGE = "rbp8_ctl";
	public String LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE = "466 green st";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CITY = "rbp10";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE = "san francisco";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CITY_WARNING_MESSAGE = "rbp10_ctl";
	public String LEGACY_USER_SIGNUP_BILL_TXT_STATE = "rbp11_ctl";
	public String LEGACY_USER_SIGNUP_SHIPPING_TXT_STATE = "psp12_ctl";
	public String LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE = "rbp12";
	public String LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE = "94133";
	public String LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_WARNING_MESSAGE = "rbp12_ctl";
	public String LEGACY_USER_SIGNUP_BILL_TXT_WARNING_MESSAGE_REQUIRED = "Required";
	public String LEGACY_USER_SIGNUP_TXT_PHONE_WARNING_MESSAGE_REQUIRED = "Phone number required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CONGRATULATION_MESSAGE = "Congratulations, your account has been created and you are ready to register for sales below!";
	public String LEGACY_USER_SIGNUP_CHK_I_AGREE = "c4_ctl";
	public String LEGACY_USER_LOT_DROPDOWN = "lstPageTop";
	public String LEGACY_USER_FRONT_BTN_ADVANCE_SEARCH = "advsSearch";
	public String LEGACY_USER_FRONT_BTN_ADVANCE_SEARCH_TOGGLE = "search_toggle_btn";
	public String LEGACY_USER_FRONT_TXT_ADVANCE_SEARCH = "advsKey";
	public String LEGACY_USER_FRONT_RADIO_BTN_CAT_ADVANCE_SEARCH = "opencollapse srch_list";
	public String LEGACY_USER_SIGNUP_TXT_CAPTCHA = "rf3";
	public String LEGACY_USER_TERMS_AND_CONDITIONS ="rf1";
	public String LEGACY_USER_SIGNUP_REGISTRATION_PANEL = "RegisterShippingPanel_ctl";
	public String LEGACY_USER_SIGNUP_LST_CC_TYPE_WARNING_MESSAGE = "rbp13_ctl";
	public String LEGACY_USER_SIGNUP_LST_CC_TYPE = "rbp13";
	public String LEGACY_USER_SIGNUP_TXT_CC_NUMBER_WARNING_MESSAGE = "rbp14_ctl";
	public String LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_MONTH_WARNING_MESSAGE = "rbp15_ctl";
	public String LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_YEAR_WARNING_MESSAGE = "c3_ctl";
	public String LEGACY_USER_SIGNUP_TXT_WARNING_MESSAGE = "warning";
	public String LEGACY_USER_SIGNUP_TXT_CC_NUMBER = "rbp14";
	public String LEGACY_USER_SIGNUP_TXT_SECURITY_CODE = "rbp17";
	public String LEGACY_USER_SIGNUP_TXT_BANK_ROUTING_WARNING_MESSAGE = "rbp18_ctl";
	public String LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT_WARNING_MESSAGE = "rbp19_ctl";
	public String LEGACY_USER_SIGNUP_LST_BANK_ACCOUNT_TYPE_WARNING_MESSAGE = "rbp20_ctl";
	public String LEGACY_USER_SIGNUP_LST_BANK_ACCOUNT_TYPE = "rbp20";
	public String LEGACY_USER_SIGNUP_TXT_BANK_NAME_WARNING_MESSAGE = "rbp21_ctl";
	public String LEGACY_USER_SIGNUP_TXT_BANK_ROUTING = "rbp18";
	public String LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT = "rbp19";
	public String LEGACY_USER_SIGNUP_TXT_BANK_NAME = "rbp21";
	public String LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT_NAME = "rbp22";
	public String LEGACY_USER_SIGNUP_MESSAGES_VALUE = "messages";
	public String LEGACY_USER_SIGNUP_MESSAGE_VALUE = "message";
	public String LEGACY_USER_SIGNUP_CAPTCHA_VALUE = "azerty-sam-Xchtpac";
	public String LEGACY_USER_SIGNUP_TXT_EDIT_CC_NUMBER = "pbp14";
	public String LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_MONTH = "rbp15";
	public String LEGACY_USER_SIGNUP_LST_CC_YEAR = "rbp16";
	public String LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE = "First name *: Required";  
	public String LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE = "First name: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE = "Last name: Required";
	public String LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE = "Last name *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE = "City *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE = "Contact Type: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE = "Address *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE = "Country: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_INVALID_PHONE_ALERT_MESSAGE = "Phone:Invalid phone number";
	public String LEGACY_USER_SIGNUP_BILL_TXT_PHONE_ALERT_MESSAGE = "Phone: Phone number required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE = "Zip/Postal Code *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE = "State/Province: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE = "CC type: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE = "CC number *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CC_MONTH_ALERT_MESSAGE = "CC Month: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CC_YEAR_MESSAGE = "CC Year: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE = "Security code *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE = "Bank routing # *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE = "Bank account # *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE = "Bank account type: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE = "Bank name *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE = "Bank account name *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_USER_NAME_ALERT_MESSAGE = "Username *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_PASSWORD_ALERT_MESSAGE = "Password *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CONFIRM_PASSWORD_ALERT_MESSAGE = "Confirm password *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_EMAIL_ALERT_MESSAGE = "Email *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_INVALID_MESSAGE = "CC number *: Problem encountered in your credit card validation";
	public String LEGACY_USER_SIGNUP_TXT_EMAIL_NOT_MATCH_ALERT = "Confirm Email *: Not match";
	public String LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL_DO_NOT_MATCH = "Confirm Email *: Emails do not match";
	public String LEGACY_USER_SIGNUP_TXT_PASSWORD_DO_NOT_MATCH = "Confirm new password *:Password do not match";
	public String LEGACY_USER_LST_NEXT_PAGE = "c2_ctl";
	public String LEGACY_USER_INFO_DATE_PICKER = "qdatetimepicker-ctl";
	public String LEGACY_USER_TXT_WINNING_MESSAGE = "youre-winning";
	public String LEGACY_USER_TXT_INVOICES_FRONTEND = "Invoices";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE = "Billing CC Expiry Date: Required";
	public String LEGACY_USER_SIGNUP_USER_INFORMATION_TAB= "User information";
	public String LEGACY_USER_SIGNUP_BILLING_INFORMATION_TAB= "Billing information";
	public String LEGACY_USER_SIGNUP_SHIPPING_INFORMATION_TAB = "Shipping information";
	public String LEGACY_USER_SIGNUP_CONFIRMATION_TAB = "Confirmation";

	// Admin Constant Elements

	public String LEGACY_ADMIN_TXT_USERS = "Users";
	public String LEGACY_ADMIN_TXT_INVENTORY = "Inventory";
	public String LEGACY_ADMIN_TXT_MANAGE_SYSTEM_PARAMETERS = "Manage System Parameters";
	public String LEGACY_ADMIN_TXT_MANAGE_USER_OPTIONS = "Users options";
	public String LEGACY_ADMIN_TXT_SECTION_REGISTRATION_SETTING = "section-registration-settings";
	public String LEGACY_ADMIN_ADDITIONAL_INFORMATION_PER_LINE_TABE = "Additional confirmations (one per line) ";
	public String LEGACY_ADMIN_ADDITIONAL_INFO_PER_LINE_TAB_CLOSE ="section-additional-confirmations";
	public String LEGACY_ADMIN_LINK_REGISTRATION_SETTINGS = "Registration Settings";
	public String LEGACY_ADMIN_TXT_OPEN ="open";
	public String LEGACY_ADMIN_TXT_CLOSE = "close";
	public String LEGACY_ADMIN_TXT_FORM_ACTON_PARAMETERS_FORM = "form action-parameters-form";
	public String LEGACY_ADMIN_CHK_SIMPLIFIED_SIGNUP_PAGE = "uof2";
	public String LEGACY_ADMIN_CHK_INCLUDE_USER_PREFERENCES = "uof66";
	public String LEGACY_ADMIN_CHK_VERIFY_EMAIL_UPON_ACCOUNT_REGISTRAIOTN = "uof10";
	public String LEGACY_ADMIN_CHK_REQUIRE_CREDIT_CARD_ON_SIGNUP = "uof11";
	public String LEGACY_ADMIN_CHK_DO_NOT_MAKE_BIDDER_UPON_SIGNUP= "uof11";
	public String LEGACY_ADMIN_CHK_INCLUDE_BILLING_ADDRESS_INFO = "uof33";
	public String LEGACY_ADMIN_CHK_MAKE_BILLING_ADDRESS_INFO_MANDATORY = "uof34";
	public String LEGACY_ADMIN_CHK_INCLUDE_ACH_INFO = "uof37";
	public String LEGACY_ADMIN_CHK_MAKE_ACH_INFO_MANDATORY = "uof38";
	public String LEGACY_ADMIN_CHK_ENABLE_RESELLER_REGISTRATION = "uof13";
	public String LEGACY_ADMIN_CHK_HIDE_COUNTRY_SELECTION_CODE = "uof78";
	public String LEGACY_ADMIN_CHK_ENABLE_CONSIGNOR_PAYMENT_INFO = "uof16";
	public String LEGACY_ADMIN_CHK_INCLUDE_BASIC_INFO = "uof31";
	public String LEGACY_ADMIN_CHK_MAKE_BASIC_INFO_MANDATORY = "uof32";
	public String LEGACY_ADMIN_CHK_INCLUDE_CC_INFO = "uof35";
	public String LEGACY_ADMIN_CHK_MAKE_CC_INFO_MANDATORY = "uof36";
	public String LEGACY_ADMIN_TXT_AMOUNT = "uof64";
	public String LEGACY_ADMIN_TXT_EXPIRES = "uof65";
	public String LEGACY_ADMIN_CHK_AUTO_ASSIGN_PREFERRED_BIDDER_PRIVILEGES = "uof14";
	public String LEGACY_ADMIN_CHK_ENABLE_LOT_UPLOAD_FOR_CONSIGNOR_USERS = "uof55";
	public String LEGACY_ADMIN_CHK_LOT_ITEM_NAME = "alf19row0";
	public String LEGACY_ADMIN_CHK_ALLOW_LOT_ASSIGNMENT_TO_AUCTION = "uof57";
	public String LEGACY_ADMIN_LST_ON_REGISTRATION = "uof63_ctl";
	public String LEGACY_ADMIN_BTN_HOME = "Home";
	public String LEGACY_ADMIN_BTN_ADD_USER = "ulf9";
	public String LEGACY_ADMIN_LNK_ACTIVE_AUCTIONS = "panel-title active-auctions";
	public String LEGACY_ADMIN_CHK_REQUIRE_CC_INFO_FOR_PLACING_BIDS = "aof52";
	public String LEGACY_ADMIN_CHK_BIDDING_NOW_UPCOMING = "spbf3[0]";
	public String LEGACY_ADMIN_CHK_BIDDING_NOW_ONLY = "spbf3[1]";
	public String LEGACY_ADMIN_CHK_UPCOMING_ONLY = "spbf3[2]";
	public String LEGACY_ADMIN_CHK_CLOSED = "spbf3[3]";
	public String LEGACY_ADMIN_TXT_SITE_CONTENT = "site-content";
	public String LEGACY_ADMIN_CHK_ENABLE_COMPANY_NAME = "uof59";
	public String LEGACY_ADMIN_CHK_REQUIRE_IDENTIFICATION = "uof67";
	public String LEGACY_ADMIN_CHK_AGENT_OPTION = "uof68";
	public String LEGACY_ADMIN_BTN_FAIR = "btnFairWarning";
	public String LEGACY_ADMIN_TXT_VERIFY_WARNING_MESSAGE = "lblAuctionHistoryMessage";
	public String LEGACY_ADMIN_BTN_QUICK_PLACE_BID = "btnAskInc3";
	public String LEGACY_ADMIN_BTN_QUICK_PLACE_BID1 = "btnAskInc4";
	public String LEGACY_ADMIN_MESSAGE_CENTER = "lblAuctionHistoryMessage";
	public String LEGACY_ADMIN_TXT_CURRENT_BID = "lblLotCurrentBid";
	public String LEGACY_ADMIN_INCREMENT_LIST = "z86";
	public String LEGACY_ADMIN_BID_INCREMENT_LIST = "z85";
	public String LEGACY_ADMIN_TXT_INCREMENT = "txtAddInc";
	public String LEGACY_ADMIN_BTN_GENERAL_SAVE_CHANGES = "scf1";
	public String LEGACY_ADMIN_BTN_SYSTEM_AUCTION_SAVE_CHANGES = "scf1";
	public String LEGACY_ADMIN_CHK_CONFIRM_MULTIPLE_TIME_LIVE_BIDS = "aof70_ctl";
	public String LEGACY_ADMIN_CHK_ALLOW_MULTIPLE_TIME_LIVE_BIDS = "aof108_ctl";
	public String LEGACY_ADMIN_CHK_ALLOW_MULTIPLE_TIMED_LIVE_BIDS = "aof108";
	public String LEGACY_ADMIN_BTN_EDIT_INVOICE_ROW = "ulf10row0";
	public String LEGACY_ADMIN_LST_START_HOUR = "aip3";
	public String LEGACY_ADMIN_LST_START_MINUTE = "aip4";
	public String LEGACY_ADMIN_LST_START_AM_PM = "aip5";
	public String LEGACY_ADMIN_LST_TIME_ZONE = "aip6";
	public String LEGACY_ADMIN_LST_END_HOUR = "aip8";
	public String LEGACY_ADMIN_LST_END_MINUTE = "aip9";
	public String LEGACY_ADMIN_LST_END_AM_PM = "aip10";
	public String LEGACY_ADMIN_LST_END_TIME_ZONE = "aip11";
	public String LEGACY_ADMIN_USER_TABLE = "ulf10";
	public String LEGACY_ADMIN_BTN_SAVE_NEW_SORT = "alf60";
	public String LEGACY_ADMIN_BTN_CONSIGNOR_SORT = "alf61";
	public String LEGACY_ADMIN_TXT_MANUAL_CLEARKING = "Manual Clerking";
	public String LEGACY_ADMIN_LST_LOT_CATEGORY_DROPDOWN = "alf102";
	public String LEGACY_ADMIN_ADVANCE_SEARCH = "section_search1";
	public String LEGACY_ADMIN_ADVANCE_ADDED_ITEMS = "section_items1";
	public String LEGACY_ADMIN_TXT_USER_CC_NUMBER = "ccnum";
	public String LEGACY_ADMIN_TXT_USER_CC_EXPIRATION_DATE = "ccexp";
	public String LEGACY_ADMIN_TXT_BIDDER_SHIPPING_ADDRESS = "saddr";
	public String LEGACY_ADMIN_TXT_BIDDER_ZIP = "szip";
	public String LEGACY_ADMIN_TXT_BIDDER_EMAIL1 = "email";
	public String LEGACY_ADMIN_CHK_BIDDER_SAME_AS_SHIPPING = "sameship";
	public String LEGACY_ADMIN_BTN_CLEARKING_CONSOLE_OK = "z76";
	public String LEGACY_ADMIN_BTN_BIDDER_NAME_OK = "z79";
	public String LEGACY_ADMIN_TXT_LOT_START_GAP_TIME_VALUE = "100";
	public String LEGACY_ADMIN_TXT_LOT_EXTEND_TIME_VALUE = "180";
	public String LEGACY_ADMIN_TXT_USER_POSTALCODE_SEARCH = "ulf29";
	public String LEGACY_ADMIN_TXT_USER_POSTALCODE_VALUE = "380015";
	public String LEGACY_ADMIN_TXT_USER_INFORMATION = "User information ";
	public String LEGACY_ADMIN_TXT_BILLING_INFORMATION = "Billing information ";
	public String LEGACY_ADMIN_TXT_USER_INFORMATION_TAB_OPEN = "user-info open";
	public String LEGACY_ADMIN_TXT_BILLING_INFORMATION_TAB_OPEN = "user-billing open";
	public String LEGACY_ADMIN_TXT_USER_INFORMATION_TAB_CLOSE = "close user-info";
	public String LEGACY_ADMIN_ICON ="fa fa-user";
	public String LEGACY_ADMIN_PAGINATION = "al23";
	public String LEGACY_ADMIN_ITEMS = "Items";

	// Run Live Auction
	public String LEGACY_ADMIN_BTN_RUN_LIVE_AUCTION = "Run Live Auction";
	public String LEGACY_ADMIN_RUN_LIVE_AUCTION = "Live auction";
	public String LEGACY_ADMIN_CONNECTED_USERS ="frmConnected";
	public String LEGACY_ADMIN_CHECKBOX_LOT ="lblUpcoming";
	public String LEGACY_ADMIN_BTN_GROUP_CHOICE = "btnGroupChoiceAll";
	public String LEGACY_ADMIN_BTN_QUICK_EDIT = "alf99qe";
	public String LEGACY_ADMIN_QUICK_EDIT = "Quick Edit";
	public String LEGACY_ADMIN_SAVE ="Save";
	public String LEGACY_ADMIN_BTN_POST_FLOOR_BID = "btnFloorBid";
	public String LEGACY_ADMIN_CONTINUE_SALE_BUTTON = "btnContinueSale";
	public String LEGACY_ADMIN_TXT_RESET_BIDDING_HISTORY = "btnResetBiddingHistory";
	public String LEGACY_ADMIN_LST_AUCTION_LIST = "alf3";
	public String LEGACY_ADMIN_BTN_ADD_LOT = "alf3";
	public String LEGACY_ADMIN_PUBLISH_DATE ="lip126";
	public String LEGACY_ADMIN_LST_INPUT_AUCTIONEER = "alf9";
	public String LEGACY_ADMIN_LST_ITEMS_PER_PAGE = "c2";
	public String LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE = "c3_ctl";
	public String LEGACY_ADMIN_BTN_START_AUCTION = "Start Auction!";
	public String LEGACY_ADMIN_BTN_START_AUCTION_BUTTON = "btnStartAuction";
	public String LEGACY_ADMIN_BTN_PAUSE_AUCTION = "btnPauseAuction";
	public String LEGACY_ADMIN_BTN_PAUSE_AUCTION_TEXT = "Pause auction!";
	public String LEGACY_ADMIN_TXT_AUCTION_SPECIFIC_SETTING_MESSAGE = "Auction Specific Settings";
	public String LEGACY_AMIN_SETTINGS_ADMIN_OPTIONS = "Admin options";
	public String LEGACY_ADMIN_SETTINGS_AUCTION_LOT_TAB = "Auction Lots Page";
	public String LEGACY_ADMIN_SETTINGS_SELECT_STATUS_ALL_FROM_DROPDWON = "aof27";
	public String LEGACY_ADMIN_SETTINGS_SAVE_CHANGES_BUTTON = "aof1";
	public String LEGACY_ADMIN_BTN_FAIR_WARNING = "btnFairWarning";
	public String LEGACY_ADMIN_BTN_PASS = "btnPass";
	public String LEGACY_ADMIN_BTN_START_LOT = "btnStartLot";
	public String LEGACY_ADMIN_TXT_VIEW_LOT_DETAIL_SCREEN = "lblLotDetails";
	public String LEGACY_ADMIN_BTN_PREVIOUS_LOT = "btnPrevLot";
	public String LEGACY_ADMIN_BTN_NEXT_LOT = "btnNextLot";
	public String LEGACY_ADMIN_SKIP_TO_LOT = "lstUpcoming";
	public String LEGACY_ADMIN_BTN_QUICKLY_CHANGE_ASKING_BID_NA = "btnAskInc2";
	public String LEGACY_ADMIN_CHK_AUTO_START_NEXT_LOT = "chkAutoStartLot";
	public String LEGACY_ADMIN_CHK_AUTO_CREATE_RECORDS_FOR_NON_EXISTING_FLOOR_BIDDERSAM_INLINE_HELP = "aof9";
	public String LEGACY_ADMIN_CHK_SELECT_FLOOR_BUYERS_FROM_DROPDOWN = "apf120";
	public String LEGACY_ADMIN_AUTO_ACCEPT_ONLINE_BIDS = "apf120";
	public String LEGACY_ADMIN_LST_INPUT_AUCTIONEER_NAME = "Sagar";
	public String LEGACY_ADMIN_LST_AUCTION_LIST_LIVE = "Live only";
	public String LEGACY_ADMIN_LST_ITEMS_PER_PAGE_HUNDRED = "100";
	public String LEGACY_ADMIN_LST_SHOW_TYPE_WARNING_MESSAGE = "alf1_ctl";
	public String LEGACY_ADMIN_LST_SHOW_TYPE = "alf1";
	public String LEGACY_ADMIN_AUCTION_TABLE = "alf4";
	public String LEGACY_ADMIN_BTN_ACCEPT_ONLINE_BID = "btnAcceptBid";
	public String LEGACY_ADMIN_BTN_SOLD_LOT = "btnSold";
	public String LEGACY_ADMIN_BTN_STOP_AUCTION = "btnStopAuction";
	public String LEGACY_ADMIN_TXT_RUN_LIVE_CHAT_TEXT_B0X = "txtBidderMessage";
	public String LEGACY_ADMIN_ENTER_BID_TAB = "Enter Bids";
	public String LEGACY_ADMIN_TXT_LOT = "aeb8";
	public String LEGACY_ADMIN_TXT_ENTER_STARTING_BID = "aeb2";
	public String LEGACY_ADMIN_TXT_ENTER_BIDDER_NAME = "aeb3";
	public String LEGACY_ADMIN_BTN_SELL_BID = "aeb5";
	public String LEGACY_ADMIN_BTN_CHAT_SEND = "btnSendMessage";
	public String LEGACY_ADMIN_LST_INPUT_BIDDER1_NAME = "rahulqa";
	public String LEGACY_ADMIN_BTN_RESUME_AUCTION = "btnResumeAuction";
	public String LEGACY_ADMIN_BTN_UNDO_LAST_ACTION = "btnUndoSnapshot";
	public String LEGACY_ADMIN_TXT_MESSAGE_TEXT_AREA = "txtBidderMessage";
	public String LEGACY_ADMIN_TXT_MESSAGE_TITLE = "txtQuickMessageTitle";
	public String LEGACY_ADMIN_BTN_SAVEAS = "btnSaveMessage";
	public String LEGACY_ADMIN_BTN_SAVE = "btnSave";
	public String LEGACY_ADMIN_BTN_SAVE_QUICK_EDIT_LOT = "alf100qs";
	public String LEGACY_ADMIN_MESSAGE_CENTER_BTN_WELCOME_SWB = "welcome swb";
	public String LEGACY_ADMIN_CHK_AUTO_ACCEPT_ONLINE = "chkAutoAcceptBid";
	public String LEGACY_ADMIN_LOT_SAVE_BUTTON_STYLE = "float:right;";
	public String LEGACY_ADMIN_TXT_SUCCESS_MESSAGE_CLASS = "alert alert-success";
	public String LEGACY_ADMIN_TXT_ERROR_MESSAGE_CLASS = "alert alert-error";
	public String LEGACY_ADMIN_LOT_SAVE_SUCCESS_MESSAGE = "url-alert alert alert-success";
	public String LEGACY_ADMIN_LOT_ERROR_MESSAGE = "url-alert alert alert-error";
	public String LEGACY_ADMIN_LST_ITEMS_PER_PAGE_VALUE = "100";
	public String LEGACY_ADMIN_TXT_CREDIT_CARD_THRESHOLD_INTERNATIONAL_VALUE = "10000";
	public String LEGACY_ADMIN_TXT_CREDIT_CARD_THRESHOLD_DOMESTIC_VALUE = "100000";
	public String LEGACY_USER_BTN_ADD_TO_WATCH_LIST = "lac19";
	public String LEGACY_USER_BTN_ADD_TO_WATCH_LIST1 = "lac19_ctl";
	public String LEGACY_USER_BTN_FOLLOW = "pbloi2";
	public String LEGACY_USER_CHK_LOT = "lac5row0";
	public String LEGACY_USER_BTN_PLACE_BID = "Place bid!";
	public String LEGACY_USER_CONFIRM_ADDITIONAL_LOTS="Confirm Addtional Lots";
	public String LEGACY_USER_STARTING_BID_NOT_MET = "Starting bid not met";
	public String LEGACY_USER_BID_VALUE = "mrg txt-max-bid";
	public String LEGACY_USER_BIDDING_VALUE = "qtextbox-ctl";
	public String LEGACY_USER_YOU_ALREADY_BID_THAT_AMOUNT = "You already bid that amount";
	public String LEGACY_REGULAR_BID_ERROR = "regular-bid-error";
	public String LEGACY_REGULAR_BID = "regular-bid";
	public String LEGACY_USER_LST_ITEMS_PER_PAGE_HUNDRED = "100";
	public String LEGACY_USER_TXT_MESSAGE_VERIFIED = "z19";
	public String LEGACY_USER_PDF_CATALOG_LINK = "lac5row0";
	public String LEGACY_USER_VIEW_CATALOG = "auclting yura";
	public String LEGACY_USER_PAGINATION = "blkPaginatorBottom";
	public String LEGACY_USER_NEXT_BTN = "Next";
	public String LEGACY_USER_VERIFY_AUCTION = "aucdes";
	public String LEGACY_USER_VIEW_ALL_LOTS = "View all lots";
	public String LEGACY_USER_AUCTION_URL = "{info_url_url}";
	public String LEGACY_USER_AUCTION_TYPE = "Live";
	public String LEGACY_ADMIN_BTN_UPLOAD_WARNING_MESSAGE = "uploadRemoteBtn";
	public String LEGACY_ADMIN_CHK_ADD_PREFERRED_USER_BIDDER = "chkPreferredBidder";
	public String LEGACY_USER_AUC_LINK = "auclink";
	public String LEGACY_USER_PLACE_BID_FROM_LOT_VALUE = "1000";
	public String LEGACY_USER_BTN_CONFIRM = "Confirm";
	public String LEGACY_USER_LST_CATEGORY = "lac4";
	public String LEGACY_USER_SELECTED_CATEGORY = "active ins_cnt description-info-content";
	public String LEGACY_USER_LST_SELECT_PAGE = "c5";
	public String LEGACY_USER_BTN_STOP_ABST_BID_SAVE = "lac12";
	public String LEGACY_USER_TXT_STOP_ABST_BID = "lac11";
	public String LEGACY_USER_TXT_STOP_ABST_BID_VALUE = "500";
	public String LEGACY_USER_CHK_STOP_ABST_BID = "lac13";
	public String LEGACY_USER_TXT_ABSENTEE_BID_VALUE = "200";
	public String LEGACY_USER_TXT_ABSENTEE_BID_VALUE_FIVE_HUNDRED = "500";
	public String LEGACY_USER_TXT_PUSH_MESSAGE_FOR_USER = "Post message";
	public String LEGACY_USER_BTN_SEND_CHAT = "z31";
	public String LEGACY_USER_BTN_VIEW_CATALOG = "View catalog";
	public String LEGACY_USER_CATALOG = "Catalog";
	public String LEGACY_USER_CUSTOM_FIELD = "other-info";
	public String LEGACY_USER_DROPDOWN_VALUE = "item-cdropdowntest";
	public String LEGACY_USER_BUY_NOW = "Buy now!";
	public String LEGACY_USER_TXT_LIVE_SALE = "Live Sale ";
	public String LEGACY_USER_TXT_LIVE_SALE_NOW = "View live sale now!";
	public String LEGACY_USER_REGISTER_NOT_BTN = "Register now!";
	public String LEGACY_USER_LOT_LINK = "lacCat_1_image";
	public String LEGACY_USER_LOT_LINK1 = "lacCat_2_image";
	public String LEGACY_USER_BTN_SEARCH_LOT = "lacSearch";
	public String LEGACY_USER_BTN_LOT_UPLOAD = "mic20_ctl";
	public String LEGACY_USER_BTN_CHANGE_BID = "Change bid!";
	public String LEGACY_USER_TXT_ITEM_ASKING = "item-askingbid";
	public String LEGACY_USER_TXT_ITEM_BUY_NOW_VALUE = "item-buynow";
	public String LEGACY_USER_TXT_LIVESALE = "catalog-live-sale-link";
	public String LEGACY_USER_TXT_LIVESALE_DISABLE = "live-bid disabled grey";
	public String LEGACY_USER_TXT_TIMED_MAX_BID = "textbox timed-maxbid";
	public String LEGACY_USER_TXT_REGULAR_LIVE_BID = "textbox live-regularbid";
	public String LEGACY_USER_LOT_IMAGE = "iuucn";
	public String LEGACY_USER_CATALOG_AUCTION_INFO = "aucinfo";
	public String LEGACY_USER_CATALOG_VIEW_MY_WATCHLIST = "catalog-mywatchlist-top";
	public String LEGACY_ADMIN_LNK_LOGOUT = "Logout";
	public String LEGACY_USER_LOT_TABLE_ROW2 = "ulf10_row0_2";
	public String LEGACY_USER_LIST_AUCTION_STATUS = "In progress";
	public String LEGACY_USER_SELECT_PAGE_FROM_DROPDOWN = "c3";
	public String LEGACY_USER_CHAT_MESSAGE = "chat-messages";
	public String LEGACY_USER_LABEL_UPCOMING = "lblUpcoming";
	
	public String LEGACY_USER_LOGIN = "Welcome";
	// Create New Auction
	public String LEGACY_ADMIN_AUCTION_TAB = "Auctions";
	public String LEGACY_ADMIN_TXT_WELCOME = "welcome";
	public String LEGACY_ADMIN_BTN_CREATE_NEW_AUCTION = "Auctions";
	public String LEGACY_ADMIN_BTN_ALF2_CREATE_NEW_AUCTION = "alf2";
	public String LEGACY_ADMIN_BTN_CREATE_AUCTION = "Create auction";
	public String LEGACY_ADMIN_LST_AUCTION_TYPE_WARNING_MESSAGE = "aip0_ctl";
	public String LEGACY_ADMIN_TXT_LIVE_ALLOW_BIDDING_CONSOLE_DATE = "aip74";
	public String LEGACY_ADMIN_TXT_PUBLISH_DATE = "aip78";
	public String LEGACY_ADMIN_TXT_START_REGISTER_DATE = "aip89";
	public String LEGACY_ADMIN_TXT_AUCTION_START_BIDDING_DATE = "aip90";
	public String LEGACY_ADMIN_TXT_START_CLOSING_DATE = "aip94";
	public String LEGACY_ADMIN_TXT_END_DATE_TIME = "aip95";
	public String LEGACY_ADMIN_TXT_NUMBER_OF_DAYS = "aip30";
	public String LEGACY_ADMIN_TXT_NUMBER_OF_DAYS_VALUE = "1";
	public String LEGACY_ADMIN_TXT_SALE = "aip13";
	public String LEGACY_ADMIN_TXT_SALE_NUMBER = "aip80"; // Old aip40 // replaced aip80
	public String LEGACY_ADMIN_DRAFT = "Drafts";
	public String LEGACY_ADMIN_TXT_SALE_NUMBER_WARNING_MESSAGE = "aip40_ctl";
	public String LEGACY_ADMIN_LST_AUCITONEER = "asf25";
	public String LEGACY_ADMIN_SETTING_NOTIFY_BIDDER = "asf53";
	public String LEGACY_ADMIN_BTN_SAVE_CHANGES = "asf1";
	public String LEGACY_ADMIN_TXT_CREDIT_CARD_THRESHOLD_DOMESTIC = "asf15";
	public String LEGACY_ADMIN_TXT_CREDIT_CARD_THRESHOLD_DOMESTIC_WARNING_MESSAGE = "asf15_ctl";
	public String LEGACY_ADMIN_TXT_CREDIT_CARD_THRESHOLD_INTERNATIONAL = "asf16";
	public String LEGACY_ADMIN_T_CREDIT_CARD_THRESHOLD_INTERNATIONAL_WARNING_MESSAGE = "asf16_ctl";
	public String LEGACY_ADMIN_LST_AUCTION_HELD_IN = "asf18";
	public String LEGACY_ADMIN_LST_AUCTION_CURRENCY = "asf19";
	public String LEGACY_ADMIN_TXT_AUCTION_SEARCH_BOX = "alf12";
	public String LEGACY_ADMIN_BTN_SEARCH_SALE = "alf13";
	public String LEGACY_ADMIN_BTN_SEARCH_SALE_NAME = "alf16";
	public String LEGACY_ADMIN_BTN_SEARCH_BUTTON ="al119";
	public String LEGACY_ADMIN_BTN_CHOOSE_FILE_AUCTION_PAGE ="liup1_ctl";
	public String LEGACY_ADMIN_REPORTS_TAB = "Reports";
	public String LEGACY_ADMIN_REPORTS_SECTION = "section_reports";
	public String LEGACY_ADMIN_BTN_DOWNLOAD_ALL_BIDS = "Download all bids";
	public String LEGACY_ADMIN_BTN_SUBMIT = "ald4";
	public String LEGACY_ADMIN_REPORRTS_ALL_AUCTION_TAB = "auction-list-autocomplete";
	public String LEGACY_ADMIN_TXT_SALE_GROUP_NA = "asf6";
	public String LEGACY_ADMIN_TXT_SALE_GROUP_EDIT = "asf9";
	public String LEGACY_ADMIN_CHK_LST_AUCTIONS = "asf11";
	public String LEGACY_ADMIN_TXT_SALE_GROUP = "asf7";
	public String LEGACY_ADMIN_BTN_PROCESS_UPLOAD = "uploadRemoteBtn";
	public String LEGACY_ADMIN_IMAGE = "auction_image_preview";
	public String LEGACY_ADMIN_TXT_PLEASE_INSERT_IMAGE_URL = "aip86";
	public String LEGACY_ADMIN_BTN_UPLOAD = "processRemoteUploadBtn";
	public String LEGACY_ADMIN_LST_AUCTION_TYPE = "alf8";
	public String LEGACY_ADMIN_BTN_CREATED_AUCTION_EDIT = "alf4_row0_12";
	public String LEGACY_ADMIN_LST_STATUS = "alf3";
	public String LEGACY_ADMIN_TXT_LOT_NUMBER = "lip117";
	public String LEGACY_ADMIN_TXT_LOT_NUMBER_WARNING_MESSAGE = "lip118";

	public String LEGACY_ADMIN_AUCTION_LOTS = "Auction Lots";
	public String LEGACY_ADMIN_LOTS_BIDDING = "lot-bidding";
	public String LEGACY_ADMIN_BIDDING = "BID";

	public String LEGACY_ADMIN_TXT_STARTING_BID = "lip18";
	public String LEGACY_ADMIN_BTN_LOTS_SAVE = "lid8";
	public String LEGACY_ADMIN_BTN_CLONE_LOT ="lid13";
	public String LEGACY_ADMIN_ENTER_AUCTION_NAME = "ui-widget";
	public String LEGACY_ADMIN_AUCTION_TEXT = "auction-list ui-autocomplete-input";
	public String LEGACY_ADMIN_BTN_YES = "cclfd1";
	public String LEGACY_ADMIN_TXT_LOT_NAME_WARNING_MESSAGE = "lip9_ctl";
	public String LEGACY_ADMIN_TXT_LOT_NAME = "lip9";
	public String LEGACY_ADMIN_TXT_LOT_NUMBER_PREFIX = "lip96";
	public String LEGACY_ADMIN_TXT_LOT_NUMBER_EXTENSION = "lip117";
	public String LEGACY_ADMIN_TXT_LOT_NUMBER_EXTENSION_VALUE_SYMBOL = "%%%%%%%%%";
	public String LEGACY_ADMIN_TXT_LOT_PARCEL_ID = "lip11";
	public String LEGACY_ADMIN_TXT_LOT_PARCEL_ID_WARNING_MESSAGE = "lip11_ctl";
	public String LEGACY_ADMIN_TXT_LOT_PARCEL_ID_VALUE = "text";
	public String LEGACY_ADMIN_TXT_LOT_PARCEL_ID_VALUE1 = "123";
	public String LEGACY_ADMIN_TXT_LOT_NUMBER_EXTENSION_WARNING_MESSAGE = "lip36_ctl";
	public String LEGACY_ADMIN_CHECKBOX_ASSIGN_TO_AUCTION = "alf24";
	public String LEGACY_ADMIN_POP_UP ="alf57_2_cald1";
	public String LEGACY_ADMIN_VERIFY_SUCCESS_TEXT ="alf29";
	public String LEGACY_ADMIN_TXT_QUANTITY = "lip72";
	public String LEGACY_ADMIN_CHK_QUANTITY_x_MONEY = "lip72";
	public String LEGACY_ADMIN_TXT_WARRANTY = "lip70";
	public String LEGACY_ADMIN_BTN__UPLOAD = "c20";
	public String LEGACY_ADMIN_LOT_TXT_PLEASE_INSERT_IMAGE_URL = "lot-images-url-box";
	public String LEGACY_ADMIN_LOT_TXT_PLEASE_INSERT_PDF_URL = "http://www.pdf995.com/samples/pdf.pdf";
	public String LEGACY_ADMIN_LOT_BTN_UPLOAD = "c28";
	public String LEGACY_ADMIN_TXT_COST = "lip82";
	public String LEGACY_ADMIN_TXT_COST_VALUE = "500";
	public String LEGACY_ADMIN_TXT_COST_VALUE_INVALID = "ff";
	public String LEGACY_ADMIN_TXT_REPLACEMENT_PRICE = "lip83";
	public String LEGACY_ADMIN_TXT_REPLACEMENT_PRICE_INVALID = "ff";
	public String LEGACY_ADMIN_TXT_RESERVE_PRICE = "lip19";
	public String LEGACY_ADMIN_TXT_RESERVE_PRICE_WARNING_MESSAGE = "lip19_ctl";
	public String LEGACY_ADMIN_TXT_RESERVE_PRICE_VALUE = "50";
	public String LEGACY_ADMIN_TXT_RESERVE_PRICE_VALUE_INVALID = "5ff0";
	public String LEGACY_ADMIN_TXT_CONSIGNOR = "lip101";
	public String LEGACY_ADMIN_TXT_SALES_TAX = "lip60";
	public String LEGACY_ADMIN_TXT_SALES_TAX_VALUE = "tt";
	public String LEGACY_ADMIN_CHK_NO_TAX_ON_SALES_OUTSIDE_OF_STATE_SAM_INLINE_HELP = "lip59";
	public String LEGACY_ADMIN_CHK_RETURNED = "lip61";
	public String LEGACY_ADMIN_CHK_FEATURED_LOT = "lip34";
	public String LEGACY_ADMIN_TXT_NOTE_TO_AUCTION_CLERK = "lip56";
	public String LEGACY_ADMIN_TXT_GENERAL_NOTE = "lip57";
	public String LEGACY_ADMIN_TXT_ITEM_WARNING_MESSAGE = "lip2_ctl";
	public String LEGACY_ADMIN_TXT_ITEM = "lip118";
	public String LEGACY_ADMIN_BTN_ADD_MORE = "lip15";
	public String LEGACY_ADMIN_BTN_CHOOSE_FILE = "c26";
	public String LEGACY_ADMIN_LOT_IMAGE = "lipimgupl2";
	public String LEGACY_ADMIN_LOT_UPLOAD_FILE_WARNING_MESSAGE = "c53_ctl";
	public String LEGACY_ADMIN_LOT_UPLOAD_EDIT_IMAGE = "Edit Images";
	public String LEGACY_ADMIN_LOT_BTN_DELETE_IMAGE = "btnrimgup2";
	public String LEGACY_ADMIN_LST_LOT_CATEGORY = "lstc1";
	public String LEGACY_ADMIN_LST_LOT_CATEGORY2 = "lstc2";
	public String LEGACY_ADMIN_LST_LOT_CATEGORY3 = "lstc3";
	public String LEGACY_ADMIN_BTN_NEW_CONSIGNOR = "lip62";
	public String LEGACY_ADMIN_MORE_ACTION_LINK= "more-actions-a";
	public String LEGACY_ADMIN_LOTS_SUB_MENUS = "tab-sub-menu";
	public String LEGACY_ADMIN_GENERATE_PDF_REPORT = "Generate PDF Report";
	public String LEGACY_ADMIN_CONSIGNORS_BY_SALE = "Consignors by Sale";
	public String LEGACY_ADMIN_PDF ="reportico-prepare-toolbar-pane";
	public String LEGACY_ADMIN_LOTS_LBL_SUB_MENUS = "more-actions-label";
	public String LEGACY_ADMIN_BTN_LOT_PDF_CATALOG = "alf38";
	public String LEGACY_ADMIN_TXT_TOTAL_ITEM_HEADER = "totalItemsHeader";
	public String LEGACY_ADMIN_LOT_ROW = "alf5row0";
	public String LEGACY_ADMIN_LOT_ROW1 = "alf5row1";
	public String LEGACY_ADMIN_LOT_TABLE = "alf5";
	public String LEGACY_ADMIN_BTN_RANDOM_LOT = "alf73";
	public String LEGACY_ADMIN_LST_SHOW_TYPE_1 = "alf16";
	public String LEGACY_ADMIN_LST_SHOW_TYPE_2 = "alf18";
	public String LEGACY_ADMIN_LST_SHOW_TYPE_3 = "alf80";
	public String LEGACY_ADMIN_TXT_TABLE_SEARCH = "alf14";
	public String LEGACY_ADMIN_BTN_POST_AUCTION_CSV = "alf75";
	public String LEGACY_ADMIN_BTN_CONSIGNOR_SEARCH = "al121";
	public String LEGACY_ADMIN_BTN_BIDDER_SUBMIT = "sbmt";
	public String LEGACY_ADMIN_TXT_BIDDER_EMAIL = "email";
	public String LEGACY_ADMIN_BTN_AUCTION_LOTS = "Auction Lots";
	public String LEGACY_ADMIN_BTN_EDIT_EXISTING_AUCTION = "alf4_row0_9";
	public String LEGACY_ADMIN_BTN_EDIT_EXISTING_AUCTION_ROW = "alf4row0";
	public String LEGACY_ADMIN_BTN_AUCTION_PAGINATION = "c1";
	public String LEGACY_ADMIN_TAB_SUB_MENU = "tab-sub-menu";
	public String LEGACY_ADMIN_LOT_BTN_AVAILABLE_ITEMS_DEV= "sectionItems2";
	public String LEGACY_ADMIN_AVAILABLE_ITEMS = "close items2";
	public String LEGACY_ADMIN_TXT_END_DATE = "aip93";
	public String LEGACY_ADMIN_TXT_START_BIDDING_DATE = "aip90";
	public String LEGACY_ADMIN_BROWSE_CSV_FILE = "liup1";
	public String LEGACY_ADMIN_BTN_ADD_NEW_BIDDER = "ab16";
	public String LEGACY_ADMIN_BTN_LOT_EDIT = "alf111";
	public String LEGACY_ADMIN_BTN_SEARCH = "al121";
	public String LEGACY_ADMIN_TXT_SEARCH_TEXT_BOX = "ab2";
	public String LEGACY_ADMIN_TXT_SEARCH_BUTTON = "ab3";
	public String LEGACY_ADMIN_TXT_LOT_ROW = "alf19_row0_3";
	public String LEGACY_ADMIN_TXT_LOT_ROW_ZERO = "c3_row0";
	public String LEGACY_ADMIN_TXT_SUCCESS_MESSAGE = "messenger";
	public String LEGACY_ADMIN_BTN_BROWSE_CSV_WARNING_MESSAGE = "aip30_ctl";
	public String LEGACY_ADMIN_TXT_HIGH_EST = "lip17";
	public String LEGACY_ADMIN_TXT_HIGH_EST_VALUE = "1000";
	public String LEGACY_ADMIN_TXT_LOT_NUMBER_VALUE = "1";
	public String LEGACY_ADMIN_TXT_LOW_EST = "lip16";
	public String LEGACY_ADMIN_TXT_LOW_EST_VALUE = "100";
	public String LEGACY_ADMIN_TXT_BUY_NOW_AT = "lip31";
	public String LEGACY_ADMIN_TXT_BUY_NOW_VALUE = "500";
	public String LEGACY_ADMIN_CHK_BUY_NOW = "lip30";
	public String LEGACY_ADMIN_TXT_LOT_START_INCREMENTS0 = "tsa";
	public String LEGACY_ADMIN_TXT_LOT_END_INCREMENTS0 = "tii";
	public String LEGACY_ADMIN_TXT_BUYER_PREMIUM_PERCENTAGE = "tpp";
	public String LEGACY_ADMIN_TXT_LOT_START_INCREMENTS = "tsa0";
	public String LEGACY_ADMIN_TXT_LOT_END_INCREMENTS = "tii0";
	public String LEGACY_ADMIN_TXT_LOT_START_INCREMENTS1 = "tsa1";
	public String LEGACY_ADMIN_TXT_LOT_END_INCREMENTS1 = "tii1";
	public String LEGACY_ADMIN_TXT_LOT_START_INCREMENTS2 = "tsa2";
	public String LEGACY_ADMIN_TXT_LOT_END_INCREMENTS2 = "tii2";
	public String LEGACY_ADMIN_TXT_LOT_START_INCREMENTS3 = "tsa3";
	public String LEGACY_ADMIN_TXT_LOT_END_INCREMENTS3 = "tii3";
	public String LEGACY_ADMIN_BTN_ADD_NEW_INCREMENT = "badd0";
	public String LEGACY_ADMIN_BTN_LOT_IMAGE = "c44";
	public String LEGACY_ADMIN_BTN_LOT_IMAGE_UPLOAD = "c17";
	public String LEGACY_ADMIN_LOT_IMAGE_UPLOAD_PATH = "https://www.extremetech.com/wp-content/uploads/2019/12/MAZDA-CX5-764A4310-640x360.jpg";
	public String LEGACY_ADMIN_LOT_BROKEN_IMAGE_LINK="https://www.bluesphere.be/images/sites/114/editor/artikels/Website-Testingg.png";
	public String LEGACY_ADMIN_BTN_LOT_IMAGE1 = "c25";
	public String LEGACY_ADMIN_LOT_ADD_MORE_IMAGE_UPLOAD_PATH = "http://blog.qatestlab.com/wp-content/uploads/2011/03/combined-testing-analysis.jpg";
	public String LEGACY_ADMIN_TXT_ADD_MORE_URL = "c49";
	public String LEGACY_ADMIN_BTN_ADD_MORE_IMAGE = "c48";
	public String LEGACY_ADMIN_TXT_IMAGE_URL = "c54";
	public String LEGACY_ADMIN_LOT_IMAGE_URL = "http://wp-content/uploads/2013/10/halloween-150x150.jpg";
	public String LEGACY_ADMIN_LST_CATEGORY = "lstc1";
	public String LEGACY_ADMIN_BTN_RE_ASSIGN_LOT = "alf89";
	public String LEGACY_ADMIN_TXT_CONSIGNER_NAME = "lip64";
	public String LEGACY_ADMIN_BTN_CONSIGNOR_SAVE = "lip65";
	public String LEGACY_ADMIN_TXT_CONSIGNOR_BOX = "alf91";
	public String LEGACY_ADMIN_TIME_LINE_AUCTION_TABLE = "bilf2";
	public String LEGACY_ADMIN_TIME_LINE_AUCTION_TABLE_ROW = "bilf2_row";
	public String LEGACY_ADMIN_CHK_PUBLIC_SOLD = "scf87";
	public String LEGACY_ADMIN_BTN_PUBLIC_SOLD_SAVE_CHANGES = "scf1";
	public String LEGACY_ADMIN_BTN_ASSIGN_TO_SALE = "alf175";
	public String LEGACY_ADMIN_TXT_WINNER_NAME = "txtBidder";
	public String LEGACY_ADMIN_BTN_SELECT_BIDDER_OK = "btnBidderOk";
	public String LEGACY_ADMIN_BTN_SOLD = "Sold";
	public String LEGACY_ADMIN_BTN_RADIO_BLOCK_COMPLETELY = "scf85_2";
	public String LEGACY_ADMIN_BTN_CHANGE_ASKING_BID = "btnChangeAsking";
	public String LEGACY_ADMIN_CHK_STAY_WITH_STARTING_INCREMENT = "bilf2b";
	public String LEGACY_ADMIN_TXT_ASKING_BID_VALUE = "80";
	public String LEGACY_ADMIN_BTN_RADIO_WARNING = "scf85_1";
	public String LEGACY_ADMIN_BTN_RADIO_NONE = "scf85_0";
	public String LEGACY_ADMIN_LST_SELECT_WINNER = "alf65";
	public String LEGACY_ADMIN_BTN_CONTINUE_SALE = "z61";
	public String LEGACY_ADMIN_TXT_CATEGORY = "lcf2";
	public String LEGACY_ADMIN_CATEGORY_TXT_PARENT_CATEGORY = "parentcat";
	public String LEGACY_ADMIN_BTN_ADD_CATEGORY = "lcf3";
	public String LEGACY_ADMIN_REQUIRED = "Required";
	public String LEGACY_ADMIN_LST_SUB_CATEGORY = "lcf6";
	public String LEGACY_ADMIN_ADDITIONAL_INVOICE_LINE_ITEMS_TABLE = "ipf18_row0_3";
	public String LEGACY_ADMIN_TXT_SEARCH_KEYWORDS = "ulf3";
	public String LEGACY_ADMIN_BTN_SEARCH_KEYWORDS = "ulf4";
	public String LEGACY_ADMIN_TABLE_EDIT_USER = "ulf10";
	public String LEGACY_ADMIN_TABLE_ROW_0 = "ulf10_row0";
	public String LEGACY_ADMIN_BTN_LOT_SAVE = "lid1";
	public String LEGACY_ADMIN_TXT_LOT_NUMBER_INVALID_VALUE = "123@#@aas";
	public String LEGACY_ADMIN_TXT_LOT_QUANTITY_INVALID_VALUE = "#@as";
	public String LEGACY_ADMIN_TXT_LOT_LOW_ESTIMATE_INVALID_VALUE = "DD";
	public String LEGACY_ADMIN_TXT_LOT_HIGH_ESTIMATE_INVALID_VALUE = "DD";
	public String LEGACY_ADMIN_TXT_LOT_STARTING_BID_INVALID_VALUE = "SS";
	public String LEGACY_ADMIN_TXT_LOT_COST_INVALID_VALUE = "L12";
	public String LEGACY_ADMIN_TXT_LOT_BUY_NOW_INVALID_VALUE = "aw";
	public String LEGACY_ADMIN_BTN_CREATE_AUCTION_ID = "aef32";
	public String LEGACY_ADMIN_BTN_AUCITON_CLONE = "aef34";
	public String LEGACY_ADMIN_BTN_LOT_ADD_IMAGE = "lot-images-url-btn";
	public String LEGACY_ADMIN_BTN_LOT_REMOVE_IMAGE = "dz-remove";
	public String LEGACY_ADMIN_TXT_IMAGE_PATH = "lot-images-url-box";
	public String LEGACY_ADMIN_CLICK_ON_YES_POPUP = "lid5_cald1";
	public String LEGACY_USER_LST_HYBRID_SELECT_PAGE = "alf5";
	public String LEGACY_USER_LOT_TXT = "yaaa";
	public String LEGACY_USER_TERMS_AND_CONDITION = "bPbid1900";
	public String LEGACY_USER_ADVANCE_SEARCH_CAT1 = "aC6";
	public String LEGACY_USER_ADVANCE_SEARCH_CAT2 = "aC7";
	public String LEGACY_USER_SELECT_CAT2 = "cat2";
	public String LEGACY_USER_SELECT_LIVE_AUCTION = "Live auctions";
	public String LEGACY_USER_CLICK_ON_EXCLUDE_LOTS = "Exclude closed lots";
	public String LEGACY_USER_TXT_SEARCH_AUCTION_BY_CAT = "aulTxtSearch";
	public String LEGACY_USER_TXT_SEARCH_CATEGORY_BUTTON = "aulBtnSearch";
	public String LEGACY_USER_BTN_CATEGORY_SEARCH_BTN = "btnSearch";
	public String LEGACY_USER_PAGE = "page";
	public String LEGACY_USER_BTN_CATEGORY_SEARCH_BTN_ADVANCE = "search_toggle_btn";
	public String LEGACY_ADMIN_BID_INCREMENT_TABLE = "bilf2";
	public String LEGACY_ADMIN_BID_INCREMENT_TABLE_ROW1 = "bilf2_row1";
	public String LEGACY_ADMIN_BID_INCREMENT_TABLE_ROW1_COL2 = "bilf2_row1_2";
	public String LEGACY_ADMIN_TXT_LOT_AUTO_EXTEND_TIME = "asf58";
	public String LEGACY_ADMIN_TXT_LOT_START_GAP_TIME = "asfGapTime";
	public String LEGACY_ADMIN_TXT_LOT_VIDEO = "https://www.youtube.com/watch?v=Y7Wg4508tHo&t=29s";
	public String LEGACY_ADMIN_CHK_ALOW_LOT_ASSIGNMENT_TO_AUCTION_TIMED = "uof58[0]";
	public String LEGACY_ADMIN_CHK_ALOW_LOT_ASSIGNMENT_TO_AUCTION_LIVE = "uof58[1]";
	public String LEGACY_ADMIN_CHK_ALOW_LOT_ASSIGNMENT_TO_AUCTION_HYBRID = "uof58[2]";
	public String LEGACY_ADMIN_BTN_INVOICE_SEND = "iid6";
	public String LEGACY_ADMIN_TXT_DESCRIPTION = "Editor, aip14";
	public String LEGACY_ADMIN_TXT_TERM_CONDITION = "Editor, aip19";
	public String LEGACY_ADMIN_BOX_DESCRIPTION = "cke_editable cke_editable_themed cke_contents_ltr cke_show_borders";
	public String LEGACY_DESCRIPTION_SPECIAL_CHARACTER_TEXT = "@#@@@@$#@!@@@#@@qweqweqweqw";
	public String LEGACY_TC_SPECIAL_CHARACTER_TEXT = "@#@@@@$#@!@@@#@@qweqweqweqw";
	public String LEGACY_ADMIN_REQUIRED_MESSAGE = "Required";
	public String LEGACY_ADMIN_CHK_REQUIRED_ABSENTEE_ABOVE_STARTING_BID = "uof50";
	public String LEGACY_ADMIN_ADD_IN_ID_COLUMN_BUTTON = "alf5row0";
	public String LEGACY_ADMIN_ADD = "add";
	public String LEGACY_ADMIN_TXT_YES_BUTTON = "caled1";
	public String LEGACY_ADMIN_TXT_UNPUBLISH_DATE = "aip92";
	public String LEGACY_ADMIN_BTN_ADD_ABSENTEE_BID ="pbf8";
	public String LEGACY_ADMIN_ENTER_VALUE_IN_MAX_BID$ ="pbf2";
	public String LEGACY_ADMIN_BTN_ADD ="pbf3";
	public String LEGACY_ADMIN_CURRENT_ABSENTEE_BID = "current-abs";
	public String LEGACY_ADMIN_CURRENT_MIN_MAX_BID = "current-min-max";
	public String LEGACY_ADMIN_CHK_REQUIRED_ABSENTEE_ABOVE_RESERVE = "uof44";
	public String LEGACY_ADMIN_CHK_NOTIFY_ABSENTEE_BIDDERS = "uof21";
	public String LEGACY_ADMIN_CHK_RESERVE_NOT_MET = "asf54";
	public String LEGACY_ADMIN_CHK_DONT_ALLOW_USER_LOWER_BID = "apf123";
	public String LEGACY_ADMIN_IMAGE_IMPORT_TAB = "Image Import";
	public String LEGACY_ADMIN_CLICK_ON_DROPDWON = "libf2";
	public String LEGACY_ADMIN_SELECT_OPTION_FROM_ASSOCIATE_MANUALLY = "Associate Manually";
	public String LEGACY_ADMIN_CLICK_ON_GO_BUTTON= "associate-btn";
	public String LEGACY_ADMIN_LOT_NAME= "libf4";
	public String LEGACY_ADMIN_CLICK_ON_GO_BUTTON1= "manually-btn";
	public String LEGACY_ADMIN_BUTTON_ADD_FILES= "btn fileinput-button";
	public String LEGACY_ADMIN_CLICK_ON_BOLD= "cke_button_icon cke_button__bold_icon";
	public String LEGACY_ADMIN_CLICK_ON_ITALIC="cke_button_icon cke_button__italic_icon";
	public String LEGACY_ADMIN_CLICK_ON_UNDERLINE="cke_button_icon cke_button__underline_icon";
	public String LEGACY_ADMIN_BTN_UPLOAD_IMAGE="button edit-lot-images";

	// Livesale

	public String LEGACY_USER_LST_SELECT_AUCTION = "licp11";
	public String LEGACY_USER_TXT_START_BIDDING_VALUE = "licp12";
	public String LEGACY_USER_TXT_DONT_SALE_ITEM = "licp27";
	public String LEGACY_USER_TXT_ESTIMATE_RANGE = "licp28";
	public String LEGACY_USER_TXT_ESTIMATE_RANGE_1 = "licp29";
	public String LEGACY_USER_BTN_IMAGE_UPLOAD = "c9";
	public String LEGACY_USER_TXT_IMAGE_UPLOAD = "c12";
	public String LEGACY_USER_BTN_IMAGE_SUBMIT = "c17";
	public String LEGACY_USER_BTN_PLACE_MULTIBID = "lac24";
	public String LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM = "pblc2";
	public String LEGACY_USER_TXT_INVENTORY_NAME = "licp4";
	public String LEGACY_USER_BTN_UPLOAD_NEW_LOT = "mic20";
	public String LEGACY_USER_BTN_SUBMIT = "licf1_ctl";
	public String LEGACY_USER_TXT_BUY_NOW_VALUE = "500";
	public String LEGACY_USER_TXT_PLACE_BID_BUTTON = "bPbid29";
	public String LEGACY_USER_TXT_PLACE_BID = "lacl4";
	public String LEGACY_USER_LST_AUCTION_SHOW = "alf1_ctl";
	public String LEGACY_ADMIN_BTN_TXT_UNGROUP = "Ungroup";
	public String LEGACY_ADMIN_BTN_TXT_POST_FLOOR = "Post floor bid";
	public String LEGACY_ADMIN_BTN_TXT_STOP_AUCTION = "Stop Auction!";

	// Bidding Live Sale

	public String LEGACY_ADMIN_BTN_EDIT_INFO = "Edit info";
	public String LEGACY_ADMIN_LST_SELECT_BIDDER = "z38";
	public String LEGACY_ADMIN_TXT_SEARCH = "miw2";
	public String LEGACY_ADMIN_BTN_LOT_SERACH = "miw3";
	public String LEGACY_ADMIN_CHK_SALE_GROUP = "asf11[0]";
	public String LEGACY_ADMIN_CHK_INCLUDE_CATEGORY_IN_INVOICE = "ipf45";
	public String LEGACY_ADMIN_CHK_INCLUDE_QUANTITY_IN_INVOICE = "ipf54";
	public String LEGACY_ADMIN_SAVE_CHANGES_INVOICE = "if1";
	public String LEGACY_ADMIN_TXT_CONSIGNEMENT_COMMISSION = "lip20b";
	public String LEGACY_ADMIN_BTN_SAVE_AND_EXIT = "lid6";
	public String LEGACY_ADMIN_BUYERS_PREMIUM_DROPDOWN = "lip119";
	public String LEGACY_ADMIN_ADD_ROW_BTN = "Add row";
	public String LEGACY_ADMIN_BTN_ASSIGN_MORE_CATEGORIES = "lip6";
	public String LEGACY_ADMIN_LST_AUCTION_LIST_TIMED_ONLY = "Timed only";
	public String LEGACY_ADMIN_LST_SELECT_LOT_SUB_CATEGORY2 = "lstcc1";
	public String LEGACY_ADMIN_LST_SELECT_LOT_SUB_CATEGORY3 = "lstccc1";
	public String LEGACY_ADMIN_LST_SELECT_LOT_SUB_CATEGORY4 = "lstcccc1";
	public String LEGACY_ADMIN_LST_SELECT_LOT_SUB_CATEGORY5 = "lstccccc1";
	public String LEGACY_ADMIN_LST_SELECT_LOT_SUB_CATEGORY6 = "lstcccccc1";
	public String LEGACY_ADMIN_LST_SELECT_LOT_SUB_CATEGORY7 = "lstccccccc1";
	public String LEGACY_ADMIN_LST_SELECT_LOT_CATEGORY = "lstc2";
	public String LEGACY_ADMIN_LST_SELECT_LOT_SUB_CATEGORY = "lstcc2";
	public String LEGACY_ADMIN_LST_SELECT_LOT_CATEGORY1 = "lstc3";
	public String LEGACY_ADMIN_LST_SELECT_LOT_SUB_CATEGORY1 = "lstcc3";
	public String LEGACY_ADMIN_BTN_EDIT_PAYTRACE = "ipf153";
	public String LEGACY_ADMIN_TXT_EDIT_PAYTRACE_NAME = "ipf146";
	public String LEGACY_ADMIN_BTN_START_AUCTION_ID = "z4";
	public String LEGACY_ADMIN_ALLOW_BUYER_TO_SELECT_QUANTITY = "lip75";

	// Admin add user

	public String LEGACY_ADMIN_TXT_USER_NAME = "uip1";
	public String LEGACY_ADMIN_TXT_FIRST_NAME = "uip4";
	public String LEGACY_ADMIN_TXT_USER_EMAIL = "usp3";
	public String LEGACY_ADMIN_TXT_CUSTOMER = "usp4";
	public String LEGACY_ADMIN_TXT_INFO_USER_NAME = "uip1";
	public String LEGACY_ADMIN_SAVE_CREATE_AUCTION = "aef5";
	public String LEGACY_LOT_BROWSE_BTN = "liupt1";
	public String LEGACY_LOT_PROCESS_UPLOAD = "alf27";
	public String Auctions = "welcome";
	public String LEGACY_ADMIN_TXT_TAB_MENU = "tab-menu";
	public String LEGACY_ADMIN_TXT_AUCTION = "Auction";
	public String LEGACY_ADMIN_CHK_SUPER_ADMIN = "chkManageArray1024";
	public String LEGACY_ADMIN_BTN_IMPERSONATE_USER = "btnImpersonate";
	public String LEGACY_ADMIN_CHK_ADMIN_PRIVILEGE = "chkAdminPrivileges";
	public String LEGACY_ADMIN_CHK_MANAGE_AUCTION = "chkManageArray1";
	public String LEGACY_ADMIN_CHK_USER_PRIVILEGES = "c21";
	public String LEGACY_ADMIN_REMAINING_USERS_TAB = "close items1";
	public String LEGACY_ADMIN_CHK_MANAGE_USERS = "chkManageArray4";
	public String LEGACY_ADMIN_BTN_RESEND_EMAIL_VERIFICATION = "c59";
	public String LEGACY_ADMIN_REGISTER_BIDDERS = "Register Bidders";
	public String LEGACY_ADMIN_ADD_NEW_BIDDER ="Add new bidder";
	public String LEGACY_ADMIN_ENTER_FIRST_NAME ="sfname";
	public String LEGACY_ADMIN_ENTER_LAST_NAME ="slname";
	public String LEGACY_ADMIN_CC_EXPIRATION_DATE = "ccexp";
	public String LEGACY_ADMIN_EXPAND_REMAINING_USER_TAB_QA_3_6_AUTO = "section-items1";
	public String LEGACY_ADMIN_EXPAND_REMAINING_USER_TAB_DEV= "unassignedUserSection";
	public String LEGACY_ADMIN_TXT_SEARCH_FILTER = "alf110";
	public String LEGACY_ADMIN_SELECT_FIRST_BIDDER = "row0-ab13 ab13-col0  first";
	public String LEGACY_ADMIN_APPROVE_FIRST_BIDDER = "row0-ab4 ab4-col0  first";
	public String LEGACY_ADMIN_BTN_REMOVE_CHECKED_BIDDER = "ab6";
	public String LEGACY_ADMIN_MESSAGE_REMOVED_BIDDER = "Removed 1 registered bidder(s)";
	public String LEGACY_ADMIN_TXT_BIDDER_CHECKBOX = "checkbox";
	public String LEGACY_ADMIN_GROUP_CHOICE = "Group (x the $)";
	public String LEGACY_ADMIN_YES_BUTTON = "Yes";
	public String LEGACY_ADMIN_APPROVE_BTN ="ab4";
	public String LEGACY_ADMIN_TXT_APPROVE_BIDDER = "bidderapprove";
	public String LEGACY_ADMIN_BIDDER_APPROVAL = "approve";
	public String LEGACY_ACCOUNT_NAME = "spaf2";
	public String LEGACY_ACCOUNT_ALLOW_BUYER = "spaf40";
	public String LEGACY_ADMIN_QUANTITY = "lip72";
	public String LEGACY_ADMIN_QUANTITY_MONEY = "lip73";
	public String LEGACY_AUCTION_BIDDER_PROCESS_UPLOAD = "ulf18";
	public String LEGACY_AUCTION_BIDDER_BROWSE_BTN = "ulf15";
	public String LEGACY_ADMIN_TXT_SEARCH_FILTER_WARNING_MESSAGE = "alf63_ctl";
	public String LEGACY_ADMIN_INVENTORY_ADD_ITEM_BUTTON = "al36";
	public String LEGACY_ADMIN_CUSTOM_FIELD_TAB = "Manage Custom Fields for Inventory";
	public String LEGACY_ADMIN_CUSTOM_FIELDS_TAB = "Custom Fields";
	public String LEGACY_ADMIN_TXT_USER_INFO_PASSWORD = "uip2";
	public String LEGACY_ADMIN_TXT_USER_PASSWORD = "uip3";
	public String LEGACY_ADMIN_TXT_USER_CONFIRM_PASSWORD = "uip3";
	public String LEGACY_ADMIN_TXT_USER_PASSWORD_VALUE = "123123a";
	public String LEGACY_FRONTEND_TXT_USER_PASSWORD_VALUE = "Abc@123";
	public String LEGACY_ADMIN_TXT_MAKE_PERMANENT_BIDDER_NUMBER = "uip6";
	public String LEGACY_ADMIN_TXT_PHONE_NUMBER = "pnuip20";
	public String LEGACY_ADMIN_TXT_PHONE_NUMBER_VALUE = "4154154141";
	public String LEGACY_ADMIN_USER_PRIVILEGES = "uidpc";
	public String LEGACY_ADMIN_TXT_CONSIGNOR_TAX = "uidpc";
	public String LEGACY_ADMIN_TXT_CONFIRM_PASSWORD = "uip3";
	public String LEGACY_ADMIN_LST_CC_TYPE = "ubp12";
	public String LEGACY_ADMIN_LST_CC_TYPE_VALUE = "1";
	public String LEGACY_ADMIN_TXT_CC_NUMBER = "q2";
	public String LEGACY_ADMIN_AMERICAN_EXPRESS_NUMBER = "378282246310005";
	public String LEGACY_ADMIN_VISA_NUMBER = "4012888888881881";
	public String LEGACY_ADMIN_SELECT_CC_MONTH = "ubp14";
	public String LEGACY_ADMIN_LST_CC_MONTH = "11";
	public String LEGACY_ADMIN_SELECT_CC_YEAR = "ubp15";
	public String LEGACY_ADMIN_LST_CC_YEAR = "5";
	public String LEGACY_ADMIN_BTN_ADD_INVENTORY = "al36";
	public String LEGACY_ADMIN_CHK_ADD_USER_BIDDER = "chkPreferredBidder";
	public String LEGACY_ADMIN_TXT_BUYERS_SALES_TEXT = "txtSalesTax";
	public String LEGACY_ADMIN_CHK_ADD_CONSIGNOR = "c45";
	public String LEGACY_ADMIN_TXT_BUYER_TAX = "c46";
	public String LEGACY_ADMIN_BTN_NEW_CREDIT_CARD = "ipf25";
	public String LEGACY_ADMIN_TABLE_CREDIT_CARD = "ipf26";
	public String LEGACY_ADMIN_TXT_CREDIT_CARD_NAME = "ipf27";
	public String LEGACY_ADMIN_BTN_CREDIT_CARD_SAVE = "ipf28";
	public String LEGACY_ADMIN_BTN_CREDIT_CARD_CANCEL = "ipf29";
	public String LEGACY_ADMIN_TXT_CREDIT_CARD_SURCHARGE = "ipf123";
	public String LEGACY_ADMIN_BTN_ADDITIONAL_INVOICE_LINE_SAVE = "ipf23";
	public String LEGACY_ADMIN_BTN_RADIO_ADDITIONAL_INVOICE_LINE_ITEM_BY_ITEM = "ipf99_1";
	public String LEGACY_ADMIN_BTN_RADIO_ADDITIONAL_INVOICE_CONSOLIDATED = "ipf99_0";
	public String LEGACY_ADMIN_LST_ADDITIONAL_INVOICE_LINE_CATEGORY = "ipf98";
	public String LEGACY_ADMIN_BTN_RADIO_ADDITIONAL_INVOICE_LINE_APPLY_ALL = "ipf22_0";
	public String LEGACY_ADMIN_BTN_RADIO_ADDITIONAL_INVOICE_LINE_APPLY_LIVE = "ipf22_2";
	public String LEGACY_ADMIN_BTN_RADIO_ADDITIONAL_INVOICE_LINE_APPLY_TIMED = "ipf22_1";
	public String LEGACY_ADMIN_CHK_ADDITIONAL_INVOICE_LINE_PER_LOT = "ipf70";
	public String LEGACY_ADMIN_CHK_ADDITIONAL_INVOICE_LINE_LIEU_OF_TAX = "ipf71";
	public String LEGACY_ADMIN_TXT_ADDITIONAL_INVOICE_LINE_AMOUNT = "ipf21";
	public String LEGACY_ADMIN_TXT_ADDITIONAL_INVOICE_LINE_LABEL = "ipf20";
	public String LEGACY_ADMIN_BTN_ADDITIONAL_INVOICE_LINE_NEW = "ipf19";
	public String LEGACY_ADMIN_TXT_SETTLEMENTS_CONSIGNOR = "slf24";
	public String LEGACY_ADMIN_LST_SETTLEMENTS_AUCTION = "slf26";
	public String LEGACY_ADMIN_LST_LOOK_AND_FEEL = "scf13";
	public String LEGACY_ADMIN_TXT_USER_CC = "q2";
	public String LEGACY_ADMIN_TXT_USER_CC_INVALID = "4578457845784578";
	public String LEGACY_ADMIN_TXT_LAST_NAME1 = "uip1";
	public String LEGACY_ADMIN_TXT_EMAIL = "uip6";
	public String LEGACY_ADMIN_TXT_SEARCH_EMAIL = "ulf30";
	public String LEGACY_ADMIN_CREDIT_CARD_ICON = "ipf26_row0_0";
	public String LEGACY_ADMIN_CHECK_BIDDER = "chkBidder";
	public String LEGACY_ADMIN_CLOSE_BILL_INFO = "close user-billing";
	public String LEGACY_ADMIN_CONTACT_TYPE = "ubp27";
	public String LEGACY_ADMIN_CLOSE_USER_SHIPPING ="close user-shipping";
	public String LEGACY_ADMIN_SHIPPING_CONTACT_TYPE ="usp15";
	public String LEGACY_ADMIN_PERMISSIONS_TAB = "Permissions";
	public String LEGACY_ADMIN_LIMITED_AUCTION_VISIBILITY_PERMISSION = "aperm1";
	public String LEGACY_ADMIN_LIMITED_AUCTION_VISIBILITY_PERMISSION_TYPE_ADMIN = "ADMIN";
	public String LEGACY_ADMIN_LIMIT_BIDDING_INFO_TO ="aperm7";
	public String LEGACY_ADMIN_LIMIT_BIDDING_INFO_TO_PERMISSION_TYPE_VISITOR ="VISITOR";
	public String LEGACY_ADMIN_SAVE_PERMISSION_CHANGES_BTN ="aperm11";
	
	

	// Admin Settings

	public String LEGACY_ADMIN_BTN_SETTINGS = "Settings";
	public String LEGACY_ADMIN_TXT_CATEGORY_START_BID = "lcf8";
	public String LEGACY_ADMIN_FILL_CONSIGNMENT = "lcf12";
	public String LEGACY_ADMIN_TXT_CATEGORY_BUYNOW = "lcf7";
	public String LEGACY_ADMIN_SETTING_TXT_STARTING_BID = "lcf8";
	public String LEGACY_ADMIN_TXT_BUY_NOW = "2000";
	public String LEGACY_ADMIN_BTN_BID_INCREMENTS = "bid-increments";
	public String LEGACY_ADMIN_TXT_LIVE_AUCTION_TABLE_ROW = "bilf2_rowh";
	public String LEGACY_ADMIN_TXT_TABLE = "bilf2";
	public String LEGACY_ADMIN_TXT_TABLE_ROW1 = "bilf2_row1";
	public String LEGACY_ADMIN_TXT_BUYERS_PREMIUM_TABLE_ID = "bp2";
	public String LEGACY_ADMIN_TXT_BUYERS_PREMIUM_TABLE_ROW1 = "bp2_row1";
	public String LEGACY_ADMIN_BUYERS_PREMIUM_TAB = "Auction Specific Buyers Premium";
	public String LEGACY_ADMIN_BUYERS_PREMIUM = "Premium";
	public String LEGACY_ADMIN_CREATE_BP_RULE = "Create new bp rule";
	public String LEGACY_ADMIN_TXT_BUYERS_PREMIUM_TABLE_ROW_COL1 = "bp2_row1_2";
	public String LEGACY_ADMIN_TXT_TABLE_BUY_PREMIUM_LIVE = "bp2";
	public String LEGACY_ADMIN_TXT_TABLE_ROW0 = "bilf2_row0";
	public String LEGACY_ADMIN_TXT_BID_INCREMENTS_SUB_CONTENT = "sub-content";
	public String LEGACY_ADMIN_TXT_BID_INCREMENTS_CONTENT = "content";
	public String LEGACY_ADMIN_TXT_BID_INCREMENTS_ROW = "bilf2_row";
	public String LEGACY_ADMIN_TXT_BID_INCREMENTS_ROW3 = "bilf2_row3";
	public String LEGACY_ADMIN_TXT_ASKING_BID = "txtAsking";
	public String LEGACY_ADMIN_TXT_RESTORE_LINK = "z64";
	public String LEGACY_ADMIN_TXT_STARTING_BID_VALUE = "100";
	public String LEGACY_ADMIN_TXT_STARTING_BID_VALUE_HUNDRED = "100";
	public String LEGACY_ADMIN_TXT_STARTING_BID_VALUE_SETTING = "5";
	public String LEGACY_ADMIN_TXT_STARTING_BID_VALUE_SETTING_test = "25";
	public String LEGACY_ADMIN_TXT_STARTING_BID_VALUE_SETTING_test_test = "11";
	public String LEGACY_ADMIN_TXT_REPLACEMENT_PRICE_VALUE = "10";
	public String LEGACY_ADMIN_BTN_TXT_POST_FLOOR_BID = "Post floor bid";
	public String LEGACY_ADMIN_TXT_CONSIGNEMENT_COMMISSION_VALUE = "20";
	public String LEGACY_ADMIN_TXT_LOT_NUMBER_EXTENSION_VALUE = "abc";
	public String LEGACY_ADMIN_TXT_LOT_NAME_VALUE = "PerfectQAServices";
	public String LEGACY_ADMIN_TXT_USER = "Users";
	public String LEGACY_ADMIN_CUSTOM_FIELD_USER_TAB = "User";
	public String LEGACY_ADMIN_TXT_CONSIGNOR_VALUE = "abddc123";
	public String LEGACY_ADMIN_TXT_INVOICING_PAYMENTS = "Invoicing & payments";
	public String LEGACY_ADMIN_TXT_ADDITONAL_BP_FOR_INTERNET_BUYERS_GLOBAL = "bp7";
	public String LEGACY_ADMIN_CHK_APPLY_STEPDOWN_CALCULATION = "bp6_0";
	public String LEGACY_ADMIN_CHK_AUCTION_SPECIFIC_APPLY_STEPDOWN_CALCULATION = "bp9";
	public String LEGACY_ADMIN_TXT_MINIMUM_BUYERS_PREMIUM_GLOBAL = "bp5";
	public String LEGACY_ADMIN_TXT_AUCTION_SPECIFIC_INTERNET_BUYERS_PREMIUM = "bp8";
	public String LEGACY_ADMIN_TXT_BUYERS_PREMIUM_FILL_SHORT_NAME = "bp9";
	public String LEGACY_ADMIN_SAVE_CHANGES_BUYERS_PREMIUM_BTN = "bp4";
	public String LEGACY_ADMIN_TXT_AUCTION_SPECIFIC_MINIMUN_BUYERS_PREMIUM = "bp7";
	public String LEGACY_ADMIN_TXT_AUCTION_SPECIFIC_MINIMUN_BUYERS_PREMIUM_TIMED = "bp5";
	public String LEGACY_ADMIN_TXT_CLOSE_USER_INFO = "close user-info";
	public String LEGACY_ADMIN_TXT_CONSIGNMENT_COMMISSION = "ipf2";
	public String LEGACY_ADMIN_TXT_CONSIGNMENT_COMMISSION_VALUE = "30";
	public String LEGACY_ADMIN_INVOICE_PAYMENTS_BTN_SAVE_CHANGES = "pf1";
	public String LEGACY_ADMIN_TXT_INVOICES = "invoices";
	public String LEGACY_ADMIN_INVOICES_TAB = "Invoices";
	public String LEGACY_ADMIN_LEGACY_INVOICES_TAB = " Legacy invoices";
	public String LEGACY_ADMIN_INVOICES_BILLING_INFORMATION = "billing-title";
	public String LEGACY_ADMIN_STACKED_TAX_INVOICES = "Stacked Tax invoices";
	public String LEGACY_ADMIN_CALC_BTN = "iid85";
	public String LEGACY_ADMIN_CALC_POP_UP ="c3";
	public String LEGACY_FRONT_RESELLER_TXT_FIELD = "rdp2";
	public String LEGACY_FRONT_RESELLER_ID = "123456";
	public String LEGACY_ADMIN_TXT_VALIDATION_MESSAGE_CLASS = "Error found at row 1: Name* required";
	public String LEGACY_ADMIN_PENDING_FROM_DROPDOWN = "c1_ctl";
	public String LEGACY_ADMIN_TXT_INVOICES_RESULT_ROW = "ilf5row0";
	public String LEGACY_ADMIN_TXT_MARK_AS_PAID = "Mark Paid";
	public String LEGACY_ADMIN_INVOICE_TABLE = "ilf5";
	public String LEGACY_ADMIN_BTN_EDIT_SALES_TAX = "edit sales tax";
	public String LEGACY_ADMIN_INVOICE_PAYMENTS_TXT_SALES_TAX = "ipf3";
	public String LEGACY_ADMIN_INVOICE_PAYMENTS_TXT_CASH_PAYMENTS = "ipf4";
	public String LEGACY_ADMIN_SYSTEM_PARAMETER_FORM = "SystemParametersInvoicingAndPaymentsForm";
	public String LEGACY_ADMIN_RADIO_BTN_APPLY_CASH_DISCOUNT = "iid3_0";
	public String LEGACY_ADMIN_RADIO_BTN_APPLY_CASH_DISCOUNT_NO = "iid3_1";
	public String LEGACY_ADMIN_SUBTOTAL_ROW1 = "c2row4";
	public String LEGACY_ADMIN_SUBTOTAL_ROW0 = "c2row0";
	public String LEGACY_ADMIN_SUBTOTAL_ROW5 = "c2row5";
	public String LEGACY_ADMIN_CHK_COMMISSIONS_AND_CHARGES_CHARGE_CONSIGNOR_COMMISSION_DIRECTLY = "ipf37";
	public String LEGACY_ADMIN_CHK_ALL_INVOICE_ITEM_CHANGES = "ipf9";
	public String LEGACY_ADMIN_CHK_SHOW_WHERE_TAXES_ARE_APPLIED_INVOICE = "ipf10";
	public String LEGACY_ADMIN_TXT_SETTLEMENTS = "settlements";
	public String LEGACY_ADMIN_TXT_SETTLEMENTS_ROW = "slf5row0";
	public String LEGACY_ADMIN_TXT_SETTLEMENTS_EDIT = "slf5";
	public String LEGACY_ADMIN_CHK_ALLOW_USER_TO_SEND_CHAT__MESSAGE_TO_CLERK_ASST_CLERK = "uof48";
	public String LEGACY_ADMIN_CHK_ALLOW_USER_TO_SEND_CHAT__MESSAGE_TO_CLERK_ASST_CLERK_WARNING_MESSAGE = "uof48_ctl";
	public String LEGACY_ADMIN_SETTING_TXT_AUCTION = "Auction";
	public String LEGACY_ADMIN_LIVE_AUCTION = "Live auction";
	public String LEGACY_ADMIN_SETTING_CHK_CONFIRM_MULTIPLE_TIMED_AND_LIVE_ABSENTEE_BIDS = "aof70";
	public String LEGACY_ADMIN_SETTING_CHK_CONFIRM_TIMED_AND_LIVE_ABSENTEE_BIDS = "aof7";
	public String LEGACY_ADMIN_SETTING_CHK_ENABLE_INLINE_BID_CONFIRMATION = "scf106";
	public String LEGACY_ADMIN_SETTING_CHK_REQUIRE_ADDRESS_CONFIRMATION_UPON_SALE_REGISTRATION = "uof19";
	public String LEGACY_ADMIN_CHK_CONSIGNOR = "asf34";
	public String LEGACY_ADMIN_BTN_SEARCH_INVENTORY = "al16";
	public String LEGACY_ADMIN_TXT_SEARCH_INVENTORY = "al15";
	public String LEGACY_ADMIN_BTN_EXPAND_SEARCH = "section_search";
	public String LEGACY_ADMIN_BTN_REASSIGN_LOT = "alf89";
	public String LEGACY_ADMIN_AUCTION_DESCRIPTION_BOLD = "cke_47";
	public String LEGACY_ADMIN_AUCTION_DESCRIPTION_UNDERLINE = "cke_12";
	public String LEGACY_ADMIN_AUCTION_DESCRIPTION_TEXT_COLOR = "cke_15";
	public String LEGACY_ADMIN_AUCTION_DESCRIPTION_BACKGROUND_COLOR = "cke_26";
	public String LEGACY_ADMIN_AUCTION_UPLOAD_IMAGE_PATH = "http://www.focus-itoutsourcing.com/wp-content/uploads/2013/10/Software-testing-trends-2013.jpg";
	public String LEGACY_ADMIN_TABLE_SETTLEMENTS_TOTAL_ROW = "slf5row0";
	public String LEGACY_ADMIN_CHK_CHARGE_CONSIGNOR_COMMISSION_DIRECTLY = "ipf37";
	public String LEGACY_ADMIN_CHK_ALLOW_INVOICE_ITEM_CHANGES = "ipf9";
	public String LEGACY_ADMIN_CHK_SHOW_WHERE_TAXES_ARE_APPLIED = "ipf10";
	public String LEGACY_ADMIN_BTN_INVOICE_SAVE_CHANGES = "iid7";
	public String LEGACY_ADMIN_CHK_SEE_EVERYONE_CHAT_MESSAGE = "uof49_ctl";
	public String LEGACY_ADMIN_CHK_SEE_EVERYONE_CHAT_MESSAGE1 = "uof49";
	public String LEGACY_ADMIN_CHK_SETTLEMENT = "ipf63";
	public String LEGACY_ADMIN_BTN_SEND_SETTLEMENT = "sid15";
	public String LEGACY_ADMIN_CHK_REQUIRE_ADDRESS_CONFIRMATION_UPON_SALE_REGISTRATION = "uof120";
	public String LEGACY_ADMIN_CHK_REQUIRE_CONFIRMATION_OF_SALE_TERMS_AND_CONDITIONS_UPON_SALE_REGISTRATION = "uof121";
	public String LEGACY_ADMIN_BTN_GENERATE_SETTLEMENT = "slf3";
	public String LEGACY_ADMIN_BTN_EDIT_SETTLEMENT_ROW = "slf5row0";
	public String LEGACY_ADMIN_TXT_EMAIL_ID = "uip6";
	public String LEGACY_ADMIN_LST_SETTLEMENT_AUCTION = "slf18";
	public String LEGACY_ADMIN_CHK_FULL_DESCRIPTION_INVOICE_LINE = "ipf65";
	public String LEGACY_ADMIN_BTN_AUCTION_SAVE_CHANGES = "aef30";
	public String LEGACY_ADMIN_BTN_RADIO_BEAN_STREAM_API_MERCHANT = "ipf90_1";
	public String LEGACY_ADMIN_TXT_MERCHANT_KEY = "ipf88";
	public String LEGACY_ADMIN_TXT_MERCHANT_VALIDATION_USERNAME = "ipf94";
	public String LEGACY_ADMIN_TXT_MERCHANT_VALIDATION_PASSWORD = "ipf95";
	public String LEGACY_ADMIN_CHK_BEAN_STREAM_ENABLE_CC = "ipf78";
	public String LEGACY_ADMIN_CHK_BEAN_STREAM_ENABLE_ACH_PAYMENT = "ipf79";
	public String LEGACY_ADMIN_CHK_BEAN_STREAM_NON_PAYMENT_TRANSACTION = "ipf80";
	public String LEGACY_ADMIN_AUTO_GENERATE_TIME_AND_LIVE_INVOICES = "ipf8";
	public String LEGACY_ADMIN_BTN_EDIT_BEAN_STREAM_DETAILS = "ipf91";
	public String LEGACY_ADMIN_BTN_RADIO_SEPARATE_TIMED_LIVE = "scf11_1";
	public String LEGACY_ADMIN_BTN_RADIO_DEFAULT = "scf11_0";
	public String LEGACY_ADMIN_BTN_RADIO_PAGE_HEADER_TEXT = "scf4_0";
	public String LEGACY_ADMIN_TXT_PAGE_HEADER_TEXT = "scf2";
	public String LEGACY_ADMIN_TXT_DISPLAY_ADDRESS = "scf6b";
	public String LEGACY_ADMIN_BTN_RADIO_UPLOAD_LOGO = "scf4_2";
	public String LEGACY_ADMIN_BTN_RADIO_LOGO_URL = "scf4_1";
	public String LEGACY_ADMIN_TXT_RADIO_LOGO_URL = "scf5";
	public String LEGACY_ADMIN_TXT_RADIO_TEXT = "scf2";
	public String LEGACY_ADMIN_BTN_BROWSE_LOGO = "c16";
	public String LEGACY_ADMIN_BTN_UPLOAD_LOGO = "c17";
	public String LEGACY_ADMIN_BIDDER_TABLE_ID = "ab13";
	public String LEGACY_ADMIN_USER_PAGE_SELECTOR = "usrDtgPerPageSelector";
	public String LEGACY_ADMIN_CHK_RAHULQA = "ab13chk2949";
	public String LEGACY_ADMIN_CHK_RAHULQA1 = "ab13chk3155";
	public String LEGACY_ADMIN_CHK_RAHULQA2 = "ab13chk4208";
	public String LEGACY_ADMIN_CHK_RAHULQA3 = "ab13chk4211";
	public String LEGACY_ADMIN_CHK_RAHULQA4 = "ab13chk4209";
	public String LEGACY_ADMIN_CHK_RAHULQA5 = "ab13chk4210";
	public String LEGACY_ADMIN_BTN_REGISTERED_CHECK_USER = "ab17";
	public String LEGACY_ADMIN_BTN_BIDDER_SEARCH = "ab12";
	public String LEGACY_ADMIN_TXT_SEARCH_BIDDER_SEARCH = "ab11";
	public String LEGACY_ADMIN_CHK_GENERATE_INVOICE_PER_USER_ACROSS_MULTIPLE_SALES = "ipf53";
	public String LEGACY_ADMIN_CHK_ENABLE_MINIMUM_BUYERS_PREMIUM = "ipf7";
	public String LEGACY_ADMIN_BTN_RADIO_AUCTION = "scf47_0";
	public String LEGACY_ADMIN_BTN_RADIO_SEARCH = "scf47_1";
	public String LEGACY_ADMIN_CHK_SHOW_MEMBER_PAGE_MENU_ITEMS_TO_VISITOR = "scf50";
	public String LEGACY_ADMIN_CHK_SHOW_FEATURED_LOT = "scf51";
	public String LEGACY_ADMIN_TXT_SHOW_FEATURED_LOTS_ON_SEARCH_PAGE = "scf18";
	public String LEGACY_ADMIN_TXT_INVOICE_BIDDER_NAME = "ilf39";
	public String LEGACY_ADMIN_BTN_CHARGE_THROUGH_BEAN_STREAM = "iid31";
	public String LEGACY_ADMIN_BTN_TRANSLATION_SAVE_CHANGES = "lcf9";
	public String LEGACY_ADMIN_TXT_LOT_ITEM_NUMBER = "lip118";
	public String LEGACY_ADMIN_TXT_LOT_ITEM_NUMBER_VALUE = "21474348647435";
	public String LEGACY_ADMIN_LST_ITEMS_PER_PAGE_BIDDER = "c6";
	public String LEGACY_ADMIN_BIDDER = "rahulqa";
	public String LEGACY_ADMIN_CATEGORIES_TAB = "Manage Categories";
	public String LEGACY_ADMIN_UPLOAD_ICON = "Upload";
	public String LEGACY_ADMIN_BIDDER2 = "rahulbid";
	public String LEGACY_ADMIN_BIDDER3 = "cided";
	public String LEGACY_ADMIN_BIDDER4 = "bidder";
	public String LEGACY_ADMIN_BIDDER5 ="rahul sharma";
	public String LEGACY_ADMIN_BTN_INVOICE_VIEW = "c2_row0";
	public String LEGACY_ADMIN_BTN_LOT_TERMS_CONDITION = "lip90";
	public String LEGACY_ADMIN_TXT_LOT_TERMS_CONDITION = "lip91";
	public String LEGACY_USER_LST_SELECT_SALE_TYPE = "alf3_ctl";
	public String LEGACY_USER_LST_SELECT_AUCTIONEER_SAGAR = "alf9_ctl";
	public String LEGACY_ADMIN_CHK_AUCTION_PUBLISH = "aef3";
	public String LEGACY_ADMIN_BTN_MAXIMIZE_INVOICE_GENERATION = "close invo";
	public String LEGACY_ADMIN_LST_INVOICE_SHOW_FILTER = "ilf2";
	public String LEGACY_ADMIN_ENABLE_US_NUMBER_FORMATTING = "scf35";
	public String LEGACY_ADMIN_KEEP_ALL_DECIMALS_ON_INVOICES_AND_SETTLEMENTS = "scf58";
	public String LEGACY_ADMIN_BTN_INVOICE_SEARCH = "ilf7";
	public String LEGACY_ADMIN_BTN_ADD_PAYMENT = "iid12";
	public String LEGACY_ADMIN_BTN_REMOVE = "bpriid1";
	public String LEGACY_ADMIN_BTN_REMOVE2 = "bpriid2";
	public String LEGACY_ADMIN_BTN_REMOVE3 = "bpriid3";
	public String LEGACY_ADMIN_BTN_REMOVE4 = "bpriid4";
	public String LEGACY_ADMIN_EDIT_INVOICES_BILLING_INFORMATION = "Billing Information:";
	public String LEGACY_ADMIN_BTN_INVOICE_EDIT_ROW = "row0-ilf5 ilf5-col20  last";
	public String LEGACY_ADMIN_BTN_EDIT_INVOICES_SAVE = "iid7";
	public String LEGACY_ADMIN_TXT_INVOICE_AUCTION_NAME = "ilf45_ctl";
	public String LEGACY_ADMIN_TXT_INVOICE_BIDDER_NAME1 = "ilf18_ctl";
	public String LEGACY_ADMIN_SELECT_USER = "stilf18_ctl";
	public String LEGACY_ADMIN_LST_DRAFT_AUCTION_NAME = "ddlf6";
	public String LEGACY_ADMIN_BTN_DRAFT_SEARCH = "ddlf5";
	public String LEGACY_ADMIN_DRAFT_AUCTION_TABLE = "ddlf11";
	public String LEGACY_ADMIN_LST_DRAFT_STATUS = "ddlf1";
	public String LEGACY_ADMIN_BTN_DRAFT_SAVE = "ddvf24";
	public String LEGACY_ADMIN_LST_DRAFT_STATUS_INNER = "ddvf0";
	public String LEGACY_ADMIN_TXT_GENERATE_INVOICE_MESSAGE = "ilf10";
	public String LEGACY_ADMIN_TXT_LOT_CONSIGNOR_SEARCH = "alf93";
	public String LEGACY_ADMIN_SEARCH_ICON = "Search";
	public String LEGACY_ADMIN_BTN_DRAFT_GENERATE = "ddlf2";
	public String LEGACY_ADMIN_USERS_TABLE_ROW_ONE = "ulf10_row0";
	public String LEGACY_ADMIN_USERS_BILLING_INFO_PANEL = "ubp12";
	public String LEGACY_ADMIN_TXT_PRINTABLE_VIEW = "Printable view";
	public String LEGACY_ADMIN_BTN_COUNTDOWN_TIMER = "btnResetRunningLotCountdown";
	public String LEGACY_ADMIN_TIMED_EXTEND_ALL = "asf49";
	public String LEGACY_ADMIN_TIMED_EXTEND_FROM_CURRENT_TIME = "asf57";
	public String LEGACY_ADMIN_TIMED_EXTEND_FROM_CURRENT_TIME_TEXTBOX = "asf58";
	public String LEGACY_ADMIN_TIMED_AUTO_EXTEND_TIME_TEXTBOX = "aof13";
	public String LEGACY_ADMIN_CHK_ALLOW_FORCE_BID = "aof17";
	public String LEGACY_ADMIN_CHK_SHOW_AUCTION_START_ENDING_BUTTON = "aof11";
	public String LEGACY_ADMIN_CHK_NEXT_BID = "sptoa3";
	public String LEGACY_ADMIN_PAGINATOR_CLASS = "paginator";
	public String LEGACY_SEND_TXT_MESSAGE = "YOU: Testing Message!!";
	public String LEGACY_PLACE_BID_ALERT = "Your bid has been placed successfully!";
	public String LEGACY_BIDDER_PROCESS_UPLOAD ="ulf18";
	public String LEGACY_BIDDER_BROWSE_BTN = "ulf15";
	public String LEGACY_ADMIN_USER_PAGINATOR_ID = "c1";
	public String LEGACY_ADMIN_INVENTORY_PAGINATOR_ID = "c4";
	public String LEGACY_ADMIN_CHK_USER_SEARCH_ADMIN = "ulf8";
	public String LEGACY_ADMIN_CHK_USER_SEARCH_BIDDER = "ulf6";
	public String LEGACY_ADMIN_CHK_USER_SEARCH_NONE = "ulf801";
	public String LEGACY_ADMIN_CHK_USER_SEARCH_CONSIGNOR = "ulf7";
	public String LEGACY_ADMIN_LST_INVENTORY_ASC_DESC = "al33";
	public String LEGACY_ADMIN_BTN_INVENTORY_RESET_SEARCH = "Reset search";
	public String LEGACY_ADMIN_LST_INVENTORY_SORTING = "al32";
	public String LEGACY_ADMIN_LST_INVENTORY_CATEGORY = "al17";
	public String LEGACY_ADMIN_TXT_INVENTORY_NAME = "al15";
	public String LEGACY_ADMIN_BTN_VALUE_SEARCH = "Search";
	public String LEGACY_ADMIN_LAYOUT_AND_SITE_CUSTOMIZATION = "Layout & site customization";
	public String LEGACY_ADMIN_LOOK_AND_FEEL_TAB = "Look & Feel";
	public String LEGACY_ADMIN_SETTING_LOCATION_TAB = "Locations";
	public String LEGACY_ADMIN_SETTINGS_DELETE_ICON ="clf16row0";
	public String LEGACY_ADMIN_DELETE = "Delete";
	public String LEGACY_ADMIN_SETTINGS_AUCTIONEERS = "Auctioneers";
	public String LEGACY_ADMIN_AUCTIONEERS_ADD_NEW_BTN = "lcf3";
	public String LEGACY_ADMIN_ACTIVATE_AUCTIONEER_FILTER = "lcf2";
	// Edit User Profile

	public String LEGACY_USER_TXT_PROFILE_FIRST_NAME = "pip5";
	public String LEGACY_USER_TXT_PROFILE_LAST_NAME = "pip6";
	public String LEGACY_USER_TXT_PROFILE_EMAIL = "pip7";
	public String LEGACY_USER_TXT_PROFILE_PHONE = "pnpip8";
	public String LEGACY_USER_TXT_PROFILE_PHONE_TYPE = "pip14";
	public String LEGACY_USER_TXT_PROFILE_IDENTIFICATION = "pip15";
	public String LEGACY_USER_TXT_PROFILE_IDENTIFICATION_TYPE = "pip16";
	public String LEGACY_USER_TXT_PROFILE_COMPANY = "c4";
	public String LEGACY_USER_TXT_PROFILE_USERROLE22 = "UsrCustFldEdt3";
	public String LEGACY_USER_BTN_SAVE_CHANGES = "pf1";
	public String LEGACY_USER_BACK_TO_LIST = "<<Back to list";
	public String LEGACY_USER_PROFILE_TAB = "Profile";
	

	// Edit User Billing information

	public String LEGACY_USER_LST_BILLING_CONTACT_TYPE = "pbp30";
	public String LEGACY_USER_TXT_BILLING_FIRST_NAME = "pbp3";
	public String LEGACY_USER_TXT_BILLING_LAST_NAME = "pbp4";
	public String LEGACY_USER_TXT_BILLING_COMPANY = "pbp2";
	public String LEGACY_USER_TXT_BILLING_PHONE = "pnpbp5";
	public String LEGACY_USER_TXT_BILLING_FAX = "pnpbp6";
	public String LEGACY_USER_TXT_BILLING_EMAIL = "pbp31";
	public String LEGACY_USER_LST_BILLING_COUNTRY = "pbp7";
	public String LEGACY_USER_TXT_BILLING_ADDRESS = "pbp8";
	public String LEGACY_USER_TXT_BILLING_ADDRESS_LINE2 = "pbp9";
	public String LEGACY_USER_TXT_BILLING_ADDRES_LINE3 = "pbp25";
	public String LEGACY_USER_TXT_BILLING_CITY = "pbp10";
	public String LEGACY_USER_LST_BILLING_STATE = "pbp49";
	public String LEGACY_USER_TXT_BILLING_ZIP = "pbp12";
	public String LEGACY_USER_TXT_BILLING_CC_TYPE = "pbp13";
	public String LEGACY_USER_TXT_BILLING_CC_NUMBER = "pbp14";
	public String LEGACY_USER_LST_BILLING_EXPIRATION_MONTH = "c6";
	public String LEGACY_USER_LST_BILLING_EXPIRATION_YEAR = "c7";
	public String LEGACY_USER_TXT_BILLING_SECURITY_CODE = "pbp19";
	public String LEGACY_USER_BILLING_PHONE2 = "UsrCustFldEdt4";
	public String LEGACY_USER_BTN_CC_EDIT = "billing-ccinfo-edit";
	

	// Edit User Shipping information

	public String LEGACY_USER_LST_SHIPPING_INFO_EDIT_CONTACT_TYPE = "psp15";
	public String LEGACY_USER_TXT_SHIPPING_INFO_EDIT_FIRST_NAME = "psp3";
	public String LEGACY_USER_TXT_SHIPPING_INFO_EDIT_LAST_NAME = "psp4";
	public String LEGACY_USER_TXT_SHIPPING_INFO_EDIT_COMPANY_NAME = "psp2";
	public String LEGACY_USER_TXT_SHIPPING_INFO_EDIT_PHONE = "pnpsp5";
	public String LEGACY_USER_TXT_SHIPPING_INFO_EDIT_FAX = "pnpsp6";
	public String LEGACY_USER_LST_SHIPPING_INFO_EDIT_COUNTRY = "psp7";
	public String LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS = "psp8";
	public String LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS_LINE2 = "psp9";
	public String LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS_LINE3 = "psp10";
	public String LEGACY_USER_TXT_SHIPPING_INFO_COUNTRY = "psp1";
	public String LEGACY_USER_TXT_SHIPPING_INFO_COUNTRY_BUTTON = "pbcp7";
	public String LEGACY_USER_TXT_SHIPPING_ENTER_CITY= "pbcp10";
	public String LEGACY_USER_TXT_SHIPPING_ENTER_ADDRESS= "pbcp8";
	public String LEGACY_USER_TXT_SHIPPING_INFO_EDIT_CITY = "psp11";
	public String LEGACY_USER_LST_SHIPPING_INFO_EDIT_STATE = "psp34";
	public String LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP = "psp13";
	public String LEGACY_USER_SHIPPING_INFO_EDIT_PREFERRED_SHIPPING_SERVICE = "psp38";
	public String LEGACY_USER_TXT_SIGNUP_PHONE_VALUE_SHIPPING = "abcd";
	public String LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP_VALUE_SHIPPING = "32482";
	public String LEGACY_USER_CHK_REMEMBER_SHIPPING_INFO = "psp36";
	public String LEGACY_USER_BTN_REGISTER_BID = "Register to bid!";
	public String LEGACY_USER_TXT_CHANGES_SAVED = "Changes Saved!";
	public String LEGACY_USER_TXT_WARNING_SUB_TITLE_0 = "sub-titles";
	public String LEGACY_USER_TXT_WARNING_SUB_TITLE_1 = "sub-titles";
	public String LEGACY_USER_TXT_WARNING_SUB_TITLE_2 = "sub-titles";
	public String LEGACY_USER_TXT_WARNING_SUB_TITLE_3 = "sub-titles";
	public String LEGACY_USER_TXT_WARNING_SUB_TITLE_4 = "sub-titles";
	public String LEGACY_USER_TXT_WARNING_SUB_TITLE_5 = "sub-titles";
	public String LEGACY_USER_TXT_WARNING_SUB_TITLE_6 = "sub-titles";
	public String LEGACY_USER_TXT_WARNING_SUB_TITLE_7 = "sub-titles";
	
	// Shipping information

	public String LEGACY_USER_LST_SHIPPING_INFO_CONTACT_TYPE = "sip15";
	public String LEGACY_USER_TXT_SHIPPING_INFO_FIRST_NAME = "sip3";
	public String LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME = "sip4";
	public String LEGACY_USER_TXT_SHIPPING_INFO_COMPANY_NAME = "sip2";
	public String LEGACY_USER_TXT_SHIPPING_INFO_PHONE = "pnsip5";
	public String LEGACY_USER_TXT_SHIPPING_INFO_FAX = "pnsip6";
	public String LEGACY_USER_LST_SHIPPING_INFO_COUNTRY = "sip7";
	public String LEGACY_USER_LST_SHIPPING_INFO_STATE1 = "sip27";
	public String LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS = "sip8";
	public String LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS_LINE2 = "sip9";
	public String LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS_LINE3 = "sip13";
	public String LEGACY_USER_TXT_SAME_AS_BILLING_CHECKBOX = "sip1";
	public String LEGACY_USER_TXT_SHIPPING_INFO_CITY = "sip10";
	public String LEGACY_USER_LST_SHIPPING_INFO_STATE = "sip11";
	public String LEGACY_USER_TXT_SHIPPING_INFO_ZIP = "sip12";
	public String LEGACY_USER_SHIPPING_INFO_PREFERRED_SHIPPING_SERVICE = "sip28";
	public String LEGACY_USER_TXT_SHIPPING_INFO_PHONE_WARNING = "pnsip5_ctl";
	public String LEGACY_USER_CHK_CLICK_ON_REMEMBER_SHIPPING_PREFERENCE_IN_PROFILE = "psp36";
	public String LEGACY_USER_TXT_YOUR_CHANGES_HAVE_BEEN_SAVED = "c10";
	public String LEGACY_USER_BTN_ = "submit";

	// Custom settings

	public String LEGACY_ADMIN_CUSTOM_SETTING_BTN_CUSTOM_FIELD = "ucflf1_ctl";
	public String LEGACY_ADMIN_ADD_CUSTOM_SETTING_BTN ="cff3";
	public String LEGACY_ADMIN_CUSTOM_SETTING_TXT_NAME = "ucfe1";
	public String LEGACY_ADMIN_CUSTOM_SETTING_TXT_NAME_AUCTION = "acfe1";
	public String LEGACY_ADMIN_CUSTOM_SETTING_TXT_ORDER = "ucfe2";
	public String LEGACY_ADMIN_CUSTOM_SETTING_TXT_ORDER_AUCTION = "acfe2";
	public String LEGACY_ADMIN_CUSTOM_SETTING_LST_TYPE = "ucfe3";
	public String LEGACY_ADMIN_CUSTOM_SETTING_LST_TYPE_AUCTION = "acfe3";
	public String LEGACY_ADMIN_CUSTOM_SETTING_CHK_REQUIRED = "ucfe5";
	public String LEGACY_ADMIN_CUSTOM_SETTINGS_CHK_ENCRYPTED = "ucfe6";
	public String LEGACY_ADMIN_CUSTOM_SETTING_CHK_ON_REGISTRATION = "ucfe7";
	public String LEGACY_ADMIN_CUSTOM_SETTING_CHK_ON_PROFILE = "ucfe8";
	public String LEGACY_ADMIN_CUSTOM_SETTING_CHK_IN_ADMIN_SEARCH = "ucfe9";
	public String LEGACY_ADMIN_CUSTOM_SETTING_CHK_INCLUDE_ON_INVOICES = "ucfe10";
	public String LEGACY_ADMIN_CUSTOM_SETTING_CHK_INCLUDE_ON_SETTLEMENTS = "ucfe14";
	public String LEGACY_ADMIN_CUSTOM_SETTING_CHK_INCLUDE_ON_ADD_NEW_BIDDER_SCREEN = "ucfe15";
	public String LEGACY_ADMIN_USER_CUSTOM_FIELD_PARAMETER = "ucfe11";
	public String LEGACY_ADMIN_CUSTOM_SETTING_BTN_SAVE_CHANGES = "ucfe12";
	public String LEGACY_ADMIN_CUSTOM_SETTING_BTN_SAVE_CHANGES_AUCTION = "acfe11";
	public String LEGACY_ADMIN_BIDDING_CONSOLE_DATE = "aip74";
	public String LEGACY_ADMIN_USERS_TAB = "User";
	public String LEGACY_ADMIN_CUSTOM_FIELDS = "ucflf2";
	public String LEGACY_ADMIN_DELETE_LINK = "deletelink";
	public String LEGACY_ADMIN_EXPAND_OPTIONS_TAB_QA_3_6_AUTO ="Options";
	public String LEGACY_ADMIN_EXPAND_OPTIONS_DEV ="legend_div";
	public String LEGACY_ADMIN_EXPAND_GENERAL_TAB_QA_3_6_AUTO ="legend_div";
	public String LEGACY_ADMIN_GENERAL_TAB = "General";
	
	

	// Custom settings Lot Item
	public String LEGACY_ADMIN_CUSTOM_SETTING_LOT_ITEM_LST_TYPE = "lcfe5";
	public String LEGACY_ADMIN_CUSTOM_SETTINGLOT_ITEM_TXT_NAME = "lcfe1";
	public String LEGACY_ADMIN_CUSTOM_SETTING_LOT_ITEMTXT_ORDER = "lcfe2";
	public String LEGACY_ADMIN_CUSTOM_FIELD_LOT_ITEM_TAB = "Lot item";
	// Payment Method

	public String LEGACY_ADMIN_CHK_PAYPAL_PAYMENTS = "ipf30";
	public String LEGACY_ADMIN_LST_INVOCIES = "c1";
	public String LEGACY_ADMIN_TXT_PAYPAL_EMAIL = "ipf31";
	public String LEGACY_ADMIN_TXT_PAYPAL_IDENTITY_TOKEN = "ipf68";
	public String LEGACY_ADMIN_BTN_SELECT_PACKAGE = "ppp11";
	public String LEGACY_ADMIN_BTN_CHARGE_VIA_AUTHORIZE_NET = "iid25";
	public String LEGACY_ADMIN_BTN_EDIT_INVOICE = "editlink";
	public String LEGACY_ADMIN_BTN_SEARCH_INVOICE = "ilf7";
	public String LEGACY_ADMIN_TXT_BIDDER = "ilf39";
	public String LEGACY_ADMIN_LST_SHOW = "c1";
	public String LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE_dev = "First name *:Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE_qa36auto = "Zip/Postal code *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE_qa36auto = "City *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE_qa36auto = "Address *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_INVALID_PHONE_ALERT_MESSAGE_qa36auto = "Phone: Invalid phone number \"+1 abcd\". Try format: \"Country Code: x National Number: xxxxxxxxxx\". The string supplied did not seem to be a phone number.";
	public String LEGACY_USER_SIGNUP_BILL_TXT_PHONE_ALERT_MESSAGE_qa36auto = "Phone: Phone number required";
	public String LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE_qa36auto = "Last name *: Required";
	public String LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE_qa36auto = "First name *: Required";
	public String LEGACY_ADMIN_USER_PRIVILEGES_OPEN = "user-privileges open";
	public String LEGACY_ADMIN_USER_PRIVILEGES_CLOSE ="user-privileges close";
	public String LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE_qa36auto = "Country: Required";
	public String LEGACY_ADMIN_CHK_USERS_CONSIGNOR_PRIVILEGE = "chkConsignor";
	public String LEGACY_ADMIN_CHK_DO_NOT_MAKE_BIDDER_ON_SIGNUP = "uof13a";
	public String LEGACY_ADMIN_CHK_REVOKE_PREFERRED_BIDDER_PRIVILEGES_ON_CC_UPDATE = "uof53";
	public String LEGACY_ADMIN_CHK_AUTO_ASSIGN_PREFERRED_BIDDER_PRIVILEGES_ON_CC_UPDATE = "uof51";
	public String LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE_qa36auto = "State/Province: Required";
	public String LEGACY_ADMIN_TXT_ERROR_MESSAGE = "iid28";
	public String LEGACY_ADMIN_CHK_USE_AUTHORIZE_NET = "ipf52";
	public String LEGACY_ADMIN_CHK_ENABLE_ACH_PAYMENTS = "ipf36";
	public String LEGACY_ADMIN_CHK_USE_AUTHORIZE_NET_FOR_NON_PAYMENT_TRANSACATION = "ipf73";
	public String LEGACY_ADMIN_CHK_NMI_CUSTOMER_MANAGEMENT = "ipf178";
	public String LEGACY_ADMIN_CHK_NMI_ENABLE_CC_PAYMENTS = "ipf180";
	public String LEGACY_ADMIN_CHK_NMI_ENABLE_ACH_PAYMENTS = "ipf181";
	public String LEGACY_ADMIN_CHK_NMI_ENABLE_USE_NMI_FOR_NON_PAYMENT_TRANSACTIONS = "ipf179";
	public String LEGACY_ADMIN_CHK_NMI_DONT_RUN_ANY_AUTOMATED_AUTHORIZATION_TRANSACTIONS = "ipf156";
	public String LEGACY_ADMIN_CHK_CLEARKING_STYLE_ADVANCE = "aip35_1";
	public String LEGACY_ADMIN_TXT_COLOR = "color:#009900;";
	public String LEGAY_ADMIN_LINK_ADD_CUSTOM_INCREMENT = "lip18a1";
	public String LEGACY_ADMIN_TXT_USER_TEXTBOX = "ulf3";
	public String LEGACY_ADMIN_BTN_SEARCH_USER = "ulf4";
	public String LEGACY_ADMIN_CHK_USERS_CONSIGNOR = "chkConsignor";
	public String LEGACY_ADMIN_TXT_USER_BUYER_TAX = "txtSalesTax";
	public String LEGACY_USER_BUY_CREDIT_BTN_PAY_VIA_PAYPAL = "bcfl3";
	public String LEGACY_USER_BUY_CREDIT_BTN_PAY_NOW = "bcfl2";
	public String LEGACY_USER_TXT_ORDER_SUMMARY = "miniCart";
	public String LEGACY_USER_TXT_BUY_MORE_CREDITS = "Buy more credits now!";
	public String LEGACY_USER_BTN_EDIT_CC = "billing-ccinfo-edit";
	public String LEGACY_USER_LST_CC_TYPE = "c18";
	public String LEGACY_USER_LST_CC_TYPE_VALUE = "Visa";
	public String LEGACY_USER_TXT_CC_NUMBER = "c19";
	public String LEGACY_USER_TXT_CC_NUMBER_VALUE = "4242424242424242";
	public String LEGACY_USER_LST_CC_EXPIRATION_MONTH = "c22";
	public String LEGACY_USER_LST_CC_EXPIRATION_MONTH_VALUE = "March";
	public String LEGACY_USER_LST_CC_EXPIRATION_YEAR = "c23";
	public String LEGACY_USER_LST_CC_EXPIRATION_YEAR_VALUE = "2020";
	public String LEGACY_USER_TXT_SECURITY_CODE = "q3";
	public String LEGACY_USER_TXT_SECURITY_CODE_VALUE = "123";
	public String LEGACY_USER_BTN_PAY_VIA_AUTHORIZE_NET = "miiv6";
	public String LEGACY_USER_TXT_SUCCESS_MESSAGE_AFTER_PAYMENT = "Success!";
	public String LEGACY_USER_CHK_ENABLE_CC_PAYMENT = "ipf38";
	public String LEGACY_USER_TXT_CC_NUMBER_VALUE_INVALID = "4345154525452545";
	public String LEGACY_USER_TXT_CC_NUMBER_VALUE_BEAN_STREAM = "4030000010001234";
	public String LEGACY_USER_BTN_RADIO_SELECT_PACKAGE = "ppp11";
	public String LEGACY_USER_BTN_EDIT_AUTHORIZE_NET_API_TRANSACTION_KEY = "ipf55";
	public String LEGACY_USER_BTN_INVOICE_VIEW = "view";
	public String LEGACY_USER_INVOICE_VIEW_ROW = "view";
	public String LEGACY_USER_BTN_PAY_VIA_PAYPAL = "c15";
	public String LEGACY_USER_BTN_PAY_NOW = "c4";
	public String LEGACY_USER_PAYPAL_FORM = "c5";
	public String LEGACY_USER_LST_VALUE_PENDING = "Pending";
	public String LEGACY_USER_LST_VALUE_SHIPPED = "Shipped";
	public String LEGACY_USER_LST_VALUE_PAID = "Paid";
	public String LEGACY_USER_LST_VALUE_PAY_NOW = "Pay now";
	public String LEGACY_USER_BUTTON_PAY_NOW = "ProfileBillingCcPanel_ctl";
	public String LEGACY_USER_SELECT_CC_TYPE = "pbcp13";
	public String LEGACY_USER_ENTER_CC = "pbcp14";
	public String LEGACY_USER_SELECT_CC_MONTH = "pbcp17";
	public String LEGACY_USER_SELECT_CC_YEAR = "pbcp18";
	public String LEGACY_USER_TXT_PAY_THROUGH_PAYTRACE_WARNING_MESSAGE = "miiv1";
	public String LEGACY_USER_BUTTON_PAY_THROUGH_PAYTRACE = "bcfl19";
	public String LEGACY_USER_BUTTON_PAY_THROUGH_PAYTRACE_INVOICE = "miiv18";
	public String LEGACY_USER_BUTTON_PAY_THROUGH_BEANSTREAM = "bcfl12";
	public String LEGACY_USER_TXT_SUCCESS_MESSAGE_AFTER_AUTHORIZE_PAYMENT = "Successfull!";
	public String LEGACY_USER_BTN_PAY_THROUGH_AUTHORIZE_NET = "bcfl10";
	public String LEGACY_USER_BTN_PAY_THROUGH_BEAN_STREAM = "miiv11";
	public String LEGACY_USER_CHK_PREFERRED_BIDDER = "chkPreferredBidder";
	public String LEGACY_ADMIN_LST_INVOICE_FILTER = "iid2";
	public String LEGACY_ADMIN_BTN_GENERATE_INVOICE = "ilf3";
	public String LEGACY_ADMIN_TXT_SEARCH_FILTER_LOTNAME = "alf112";
	public String LEGACY_USER_BTN_PLACEBID_LOTDETAILS = "button orng next-bid";
	public String LEGACY_USER_BTN_PLACEBID_COUNTER = "button orng next-bid inline-confirm";
	public String LEGACY_USER_BTN_PLACEBID_CONFIRM = "orng place-bid button inline-confirm";
	public String LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS = "left cur_bid";
	public String LEGACY_USER_BTN_FORCE_BID_COUNTER = "force-bid inline-confirm";
	public String LEGACY_USER_BUTTON = "button";
	public String LEGACY_FRONT_LIVE_SALE = "Live only";
	public String LEGACY_USER_BTN_FORCE_BID = "Force Bid";
	public String LEGACY_USER_BTN_FORCE_BID_CONFIRM = "force-bid button inline-confirm";
	public String LEGACY_USER_TXT_TIMEDSALE_FORCEBID_TEXTBOX = "textbox timed-forcebid";
	public String LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX = "textbox timed-maxbid";
	public String LEGACY_USER_LOT_PRICE_INFO = "price-info";
	public String LEGACY_USER_BTN_NEXT = "Next";
	public String LEGACY_USER_PAGE_INIT = "right pagintn";
	public String LEGACY_USER_BIDDING_PAUSED= "Bidding paused";
	public String LEGACY_USER_LOT_DETAIL= "item-block-wrapper";
	public String LEGACY_USER_SELECT_CATEGORY ="category-link";
	public String LEGACY_USER_ESTIMATE ="Estimates";
	public String LEGACY_USER_ESTIMATE_VALUE ="value";
	public String LEGACY_USER_BID_MESSAGE = "wrapper";
	public String LEGACY_USER_ADVANCE_SEARCH = "Advanced Search";

	// Translations Main Menu

	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_ACCOUNTS = "lcf8txt0";
	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_AUCTIONS = "lcf8txt1";

	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_INVOICES = "lcf8txt2";
	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_LOGIN = "lcf8txt3";
	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_LOGOUT = "lcf8txt4";

	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_MYALERTS = "lcf8txt5";

	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_MYBUYERS = "lcf8txt6";
	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_MYITEMS = "lcf8txt7";
	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_MYPROFILE = "lcf8txt8";
	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_SEARCH = "lcf8txt9";

	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_SETTLEMENTS = "lcf8txt10";
	public String LEGACY_ADMIN_TRANSLATIONS_MAIN_MENU_TXT_SIGNUP = "lcf8txt11";
	public String LEGACY_ADMIN_TXT_TRANSLATIONS = "Translations";

	// Translation Tab Names

	public String LEGACY_ADMIN_TRANSLATIONS_TAB_NAMES_TXT_ALL = "lcf8txt0";
	public String LEGACY_ADMIN_TRANSLATIONS_TAB_NAMES_TXT_AUCTION = "lcf8txt1";
	public String LEGACY_ADMIN_TRANSLATIONS_TAB_NAMES_TXT_LIVE_SALE = "lcf8txt2";
	public String LEGACY_ADMIN_TRANSLATIONS_TAB_NAMES_TXT_LIVE_SEARCH = "lcf8txt3";
	public String LEGACY_ADMIN_TRANSLATIONS_TAB_NAMES_TXT_SEARCH = "lcf8txt4";
	public String LEGACY_ADMIN_TRANSLATIONS_TAB_NAMES_TXT_TIMED_SALE = "lcf8txt5";
	public String LEGACY_ADMIN_TRANSLATIONS_TAB_NAMES_TXT_TIMED_SEARCH = "lcf8txt6";

	// Translation Auctions

	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_AUCTIONNER = "lcf8txt1";

	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_DESCRIPTION = "lcf8txt2";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_AUCTION_EMAIL = "lcf8txt3";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_FEATURED_LOTS = "lcf8txt4";

	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LOCATION = "lcf8txt5";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_SHIPPING_INFO = "lcf8txt6";

	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_TERMS_AND_CONDITION = "lcf8txt7";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_TIME_LEFT = "lcf8txt8";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_AUCTION_TYPE = "lcf8txt9";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_VIEW_ALL_LOTS = "lcf8txt10";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_VIEW_LIVE_SALE_NOW = "lcf8txt11";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_YOU_DO_NOT_HAVE_PERMISSION_TO_ACCESS_THIS_PAGE = "lcf8txt12";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_ADVANCE = "lcf8txt13";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_ALL_AUCTIONNERS = "lcf8txt14";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_ALL_SALES = "lcf8txt15";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_CATALOG = "lcf8txt16";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_MM_DD_YYYY_H_MM_ZZ = "lcf8txt17";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_MM_DD_H_MM_SS_ZZ = "lcf8txt18";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_MM_DD_YYYY = "lcf8txt19";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_ONGOING_EVENT = "lcf8txt20";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_HYBRID = "lcf8txt21";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LIVE = "lcf8txt22";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_TIMED = "lcf8txt23";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_HYBRID_ONLY = "lcf8txt24";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_AUCTION_INFO = "lcf8txt25";

	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LIVE_ONLY = "lcf8txt26";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LIVE_SALE = "lcf8txt27";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_SORRY_YOU_DONT_HAVE_BIDDER_PRIVILEGES = "lcf8txt28";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_ENTER_THE_NUMBER_OF_DAYS_THAT_THE_LIVE_EVENT_NEEDS_FOR_ACCESSIBLE_FOR = "lcf8txt29";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LOTS_WHICH_ARE_NOT_LISTED_WERE_WITH_DRAWN_PRIOR = "lcf8txt30";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_REGISTERD = "lcf8txt31";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_YOUR_AUCTION_REGISTRATION_IS_PENDING_APPROVAL = "lcf8txt32";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_REGISTER_FOR_AUCTION = "lcf8txt33";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_THE_AUCTION_WILL_NOT_BE_VISIBLE_TO_YOU_UNTIL = "lcf8txt34";

	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_SALES_END_IN = "lcf8txt38";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_SALES_STARTS_IN = "lcf8txt39";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_SHOW = "lcf8txt40";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_ALL = "lcf8txt41";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_BIDDING_NOW_ONLY = "lcf8txt42";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_BIDDING_NOW_AND_UPCOMING = "lcf8txt43";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_CLOSED = "lcf8txt44";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_UPCOMING_ONLY = "lcf8txt45";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_STARTS_ENDING = "lcf8txt46";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_AUCTION_DATE = "lcf8txt47";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LOTS = "lcf8txt48";

	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_NAME = "lcf8txt49";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_SALES = "lcf8txt50";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_TIMED_ONLY = "lcf8txt51";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_VIEW_CATALOG = "lcf8txt52";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_PRICES_REALIZED = "lcf8txt53";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_AUCTION_DATE1 = "lcf8txt54";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_AUCTIONEER = "lcf8txt55";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LAST_UPDATED = "lcf8txt56";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LOT = "lcf8txt57";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LOTS1 = "lcf8txt58";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LOT_SOLD = "lcf8txt59";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LOT_COUNT = "lcf8txt60";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_LOT_HASH = "lcf8txt61";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_REALIZED = "lcf8txt62";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_PRICES_REALIZED_RESULT = "lcf8txt63";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_AUCTION_RESULTS = "lcf8txt64";

	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_TITLE_DESCRIPTION = "lcf8txt72";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_AUCTION_AGREEMENT_NUMBER_S = "lcf8txt73";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_SCHEDULE_A = "lcf8txt74";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_AUCTION_COMPANY = "lcf8txt75";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_CONSIGNOR = "lcf8txt76";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_ARIL = "lcf8txt83";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_AUGUST = "lcf8txt84";

	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_DECEMBER = "lcf8txt85";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_FEBRUARY = "lcf8txt86";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_JANUARY = "lcf8txt87";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_JULY = "lcf8txt88";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_JUNE = "lcf8txt89";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_MARCH = "lcf8txt90";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_MAY = "lcf8txt91";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_NOVEMBER = "lcf8txt92";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_OCTOBER = "lcf8txt93";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_SEPTEMBER = "lcf8txt94";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_CANCELLED = "lcf8txt95";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_DELETED = "lcf8txt96";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_BANK_WIRE = "lcf8txt97";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_CASH = "lcf8txt98";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_CASHIER_CHECK = "lcf8txt99";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_CHECK = "lcf8txt100";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_CREDIT_CARD = "lcf8txt101";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_CREDIT_MEMO = "lcf8txt102";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_GOOGLE_CHECKOUT = "lcf8txt103";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_MONEY_ORDER = "lcf8txt104";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_OTHER = "lcf8txt105";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_PAYPAL = "lcf8txt106";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_OPEN = "lcf8txt107";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_PAID = "lcf8txt108";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_PENDING = "lcf8txt109";
	public String LEGACY_ADMIN_TRANSLATIONS_AUCTIONS_TXT_SHIPPED = "lcf8txt110";

	// Translation Catalog

	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT = "Catalog";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOUR_ABSENTEE_BIDS_HAVE_NOT_BEEN_PLACED = "lcf8txt0";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_THIS_LOT_HAS_BEEN_ALREADY_BEEN_AWARED = "lcf8txt1";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_THIS_LOT_HAS_BEEN_ALREADY_BEEN_SOLD = "lcf8txt2";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ACCEPT_AND_SELL = "lcf8txt3";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ACCEPT_AND_SELL_HAS_BEEN_DISABLED = "lcf8txt4";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ADD_TO_WATCH_LIST = "lcf8txt5";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ADD_TO_WATCH_LIST1 = "lcf8txt6";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ADD_TO_WATCH_LIST2 = "lcf8txt7";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_AND_FORCE_BID_TO_S_S = "lcf8txt8";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ASKING = "lcf8txt9";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ASK_A_QUESTION = "lcf8txt10";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_AWARDED = "lcf8txt11";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_AWARDED_WITH_RESERVATION = "lcf8txt12";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_BACK_TO_LIST = "lcf8txt13";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_BE_THE_FIRST_TO_BID_ON_THIS_ITEM = "lcf8txt14";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_SORRY_YOU_DONT_HAVE_BIDDER_PRIVILEGES = "lcf8txt15";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PLEASE_BID_AGAIN = "lcf8txt16";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_BUY_NOW = "lcf8txt17";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_TOO_BIG_AMOUNT = "lcf8txt18";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_TOO_SMALL_AMOUNT = "lcf8txt19";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOU_HAVE_BEEN_OUT_BID = "lcf8txt20";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOUR_CURRENT_TOTAL_SPENT_ON_THIS_ITEM_IS_S = "lcf8txt22";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOU_ARE_THE_HIGHER_BIDDER = "lcf8txt23";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_BID_WAS_PLACED_BUT_BELOW_HIGH_ABS_BID = "lcf8txt21";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOUR_BID_HAS_BEEN_PLACED_SUCCESSFULLY = "lcf8txt22";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOUR_BID_HAS_BEEN_PLACED_SUCCESSFULLY1 = "lcf8txt23";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_SUCCESSFULLY_UPDATED_BID_ON_LOT_S = "lcf8txt24";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TOO_BIG_AMOUNT = "lcf8txt25";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_TOO_SMALL_AMOUNT1 = "lcf8txt26";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOUR_BID_WAS_HIGHR_THAN_SOMEONE_ELSE_MIN_BID = "lcf8txt27";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOUR_BID_WAS_LOWER_THAN_SOMEONE_ELSE_MAX_BID = "lcf8txt28";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOU_ARE_THE_HIGHR_BIDDER = "lcf8txt29";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOU_ARE_THE_LOW_BIDDER = "lcf8txt30";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_BULK_GROUP_MASTER_LOT = "lcf8txt31";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PLACE_S_OR_MORE_TO_WIN_THE_GROUP = "lcf8txt32";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_BUY_NOW1 = "lcf8txt34";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_THE_AUCTION_HAS_ALREADY_STARTED = "lcf8txt35";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_SORRY_YOU_CANNOT_BUY_THIS_ITEM_ANYMORE = "lcf8txt36";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_THIS_LOT_CURRENTLY_UP_FOR_BIDDING = "lcf8txt37";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_CATEGORIES = "lcf8txt40";
	String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_CHANGES = "lcf8txt41";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_CLICK_IMAGE_TO_ENLARGE = "lcf8txt42";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_CONFIRM_S = "lcf8txt44";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_MONTH_DAY_YEAR_HOUR_MINUTE_AM_PM_TZ = "lcf8txt45";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_HOURS_MINUTES_SECONDS = "lcf8txt46";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_MINUTES_SECONDS = "lcf8txt47";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_SECONDS = "lcf8txt48";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_CURRENT_BID = "lcf8txt49";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_CURRENT_ABSENTEE = "lcf8txt50";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_DESCRIPTION = "lcf8txt51";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ESTIMATE = "lcf8txt52";

	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_EXCLUDE_CLOSED_LOTS = "lcf8txt53";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ALL = "lcf8txt54";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_CATEGORY = "lcf8txt55";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PAYING_INVOICE_NOW = "lcf8txt56";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PAYING_THE_INVOICE_NOW = "lcf8txt57";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PLEASE_FINALIZE_YOUR_PURCHASE = "lcf8txt58";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_FORCE_BID = "lcf8txt59";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_INVALID_FORCE_BID = "lcf8txt60";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_FORCE_BID_OF_S = "lcf8txt61";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_FORCE_BID_AMOUNT_TOO_BIG = "lcf8txt62";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_FORCE_BID_AMOUNT_TOO_SMALL = "lcf8txt63";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PLACE_BID_LIVE_SALE_PAGE = "lcf8txt64";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_HIGH_TO_LOW = "lcf8txt65";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_INVALID_OR_BID = "lcf8txt66";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_INVOICE_ISSUED_SHORTLY = "lcf8txt67";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ITEM_NUMBER = "lcf8txt68";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_LOADING = "lcf8txt69";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_LOT_OF_S = "lcf8txt70";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOU_ALREADY_REGISTERED = "lcf8txt71";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ACCEPT_LOT_CHANGES = "lcf8txt72";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_LOT_CLOSED = "lcf8txt73";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_CLICK_ON_LEFT_RIGHT_SIDE_IMAGE = "lcf8txt74";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ARE_YOU_SURE_YOU_WANT_TO_SELL = "lcf8txt75";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_LOT_S_STARTED = "lcf8txt76";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ITEM_SUCCESSFULLY_ADDED_TO_WATCHLIST = "lcf8txt77";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_LOW_TO_HIGH = "lcf8txt78";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_MAX_BID_OF_S = "lcf8txt79";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_BIDDING_ON_MULTIPLE_LOTS_AT_ONCE = "lcf8txt80";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_MY_MAX_BID = "lcf8txt81";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_MY_MIN_BID = "lcf8txt82";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_BID = "lcf8txt83";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_NEXT = "lcf8txt84";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_NO_VALID_BIDS_YET = "lcf8txt86";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_CHANGE_OFFER = "lcf8txt87";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOUR_OFFER_HAS_BEEN_DECLINED = "lcf8txt88";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_MAKE_OFFER = "lcf8txt89";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_DONT_HAVE_BIDDER_PRIVILEGES = "lcf8txt90";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_OFFER_HAS_BEEN_SUBMITTED_EMAIL = "lcf8txt91";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_OFFER_SUBMITTED = "lcf8txt92";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_YOUR_OFFER = "lcf8txt93";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_OPENING_BID = "lcf8txt95";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_OR_BID_NUMBER = "lcf8txt96";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_OTHER_LOTS_IN_THIS_SALE = "lcf8txt97";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_LOT = "lcf8txt98";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_AUCTION = "lcf8txt100";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PDF_CATALOG = "lcf8txt101";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_LOT1 = "lcf8txt102";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PDF_PRICE_REALIZED = "lcf8txt103";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PIECEMENT_LOT = "lcf8txt104";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PLACE_MULTIPLE_BIDS = "lcf8txt105";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PREVIOUS = "lcf8txt106";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_PRICE = "lcf8txt107";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_QUANTITY = "lcf8txt108";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_BIDDING_ON_THIS_LOT = "lcf8txt109";

	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_RECEIVED_YOUR_PAYMENT = "lcf8txt110";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_REMOVE_FROM_WATCHLIST = "lcf8txt111";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_RESERVE_MET = "lcf8txt112";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_RESERVE_NOT_MET = "lcf8txt113";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_RESET_SEARCH = "lcf8txt114";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ARTIST_STATEMENT = "lcf8txt115";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_SELECT_AT_LIST_1_ITEM = "lcf8txt116";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_LOT2 = "lcf8txt117";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_SOLD = "lcf8txt118";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_SOLD_WITH_RESERVATION = "lcf8txt119";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_SOLD_THROUGH_BUY_NOW = "lcf8txt120";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_SORT = "lcf8txt122";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_BIDS = "lcf8txt123";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_CATEGORY1 = "lcf8txt124";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ESTIMATE1 = "lcf8txt125";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ITEM = "lcf8txt126";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_LOT3 = "lcf8txt127";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_NAME = "lcf8txt128";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STARTING_CURRENT_BID = "lcf8txt129";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_TIME_LEFT = "lcf8txt130";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_VIEWS = "lcf8txt131";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_SPECIAL_TERMS = "lcf8txt132";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STARTING = "lcf8txt133";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STARTING_BID_NOT_MET = "lcf8txt134";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS = "lcf8txt135";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STOP_ABSENTEE_BIDDING_AT = "lcf8txt136";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_SUBMIT = "lcf8txt137";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_BUYNOW = "lcf8txt138";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ESTIMATE2 = "lcf8txt139";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_IMAGE = "lcf8txt140";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_ITEM_TITLE = "lcf8txt141";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_LOT4 = "lcf8txt142";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_MY_MAX_BID1 = "lcf8txt143";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_MY_MIN_BID1 = "lcf8txt144";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_OR = "lcf8txt145";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_PRICE = "lcf8txt146";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_ASKING_BID = "lcf8txt147";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_BUY_NOW = "lcf8txt148";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_CURRENT_BID = "lcf8txt149";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_STARTING_BID = "lcf8txt150";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_WINNING_BID = "lcf8txt151";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_QUANTITY = "lcf8txt152";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_TIME_LEFT = "lcf8txt153";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_WARRANTY = "lcf8txt154";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_QUESTIONMARK = "lcf8txt155";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_YOUR_BIDS = "lcf8txt156";

	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_TELL_A_FRIEND = "lcf8txt157";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_TERMS_AND_CONDITION = "lcf8txt158";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_TIME_LEFT1 = "lcf8txt159";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_ENDED = "lcf8txt160";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_UNAWARDED = "lcf8txt161";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_UNSOLD = "lcf8txt162";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_UPCOMING = "lcf8txt163";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_VIEW_DETAILS = "lcf8txt164";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_VIEW_FULL_CATALOG_FOR = "lcf8txt165";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_VIEW_FULL_CATALOG_FOR1 = "lcf8txt166";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_VIEW_MY_WATCHLIST = "lcf8txt167";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_WARRANTY1 = "lcf8txt168";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_ADD_TO_WATCHLIST = "lcf8txt169";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_OR_WINNING_BID = "lcf8txt170";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_YOU_WON = "lcf8txt171";
	public String LEGACY_ADMIN_TRANSLATIONS_CATALOG_TXT_STATUS_YOU_WON_RESERVTION = "lcf8txt172";

	// Translation Search

	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_AUCTION_ITEMS = "lcf8txt0";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_ACCOUNT = "lcf8txt1";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_AUCTIONEER = "lcf8txt2";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_AUCTIONS = "lcf8txt3";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_BEST_OFFER = "lcf8txt4";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_BUY_NOW = "lcf8txt5";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_FEATURED = "lcf8txt6";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_FILTER_BY = "lcf8txt7";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_HYBRID_AUCTIONS = "lcf8txt8";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_LIVE_AUCTIONS = "lcf8txt9";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_LOT_NUMBER = "lcf8txt10";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_PRICE = "lcf8txt11";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_MAX = "lcf8txt12";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_MIN = "lcf8txt13";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_SORT_BY = "lcf8txt14";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_TIMED_AUCTIONS = "lcf8txt15";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_BID_NOW = "lcf8txt16";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_SEARCH = "lcf8txt17";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_BUYNOW = "lcf8txt18";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_CATEGORIES = "lcf8txt18";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_ALL = "lcf8txt18";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_CATEGORY_MATCH = "lcf8txt19";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_ENTER_ZIP_POSTAL_CODE = "lcf8txt27";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_POSTAL_CODE_FORMAT = "lcf8txt28";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_POSTAL_CODE_NOT_FOUND = "lcf8txt29";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_SELECT_RADIUS = "lcf8txt30";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_LOT_IN_SALE = "lcf8txt31";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_KEYWORDS = "lcf8txt32";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_ADD_ALERT = "lcf8txt33";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_REACHED_MAX = "lcf8txt34";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_SAVE_ALERT = "lcf8txt35";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_SEARCH_TITLE = "lcf8txt36";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_SAVE_SEARCH = "lcf8txt37";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_MY_SEARCHES = "lcf8txt38";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_SEARCH_RADIUS = "lcf8txt39";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_MILES = "lcf8txt40";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_SELECT = "lcf8txt41";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_UNAWARDED = "lcf8txt42";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_UNSOLD = "lcf8txt43";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_SIMILAR_ITEMS = "lcf8txt41";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_AUCTION = "lcf8txt42";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_BIDS = "lcf8txt43";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_DEFAULT = "lcf8txt44";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_DISTANCE = "lcf8txt45";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_HIGH_PRICE = "lcf8txt46";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_LOT_NAME = "lcf8txt47";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_LOTHASH = "lcf8txt48";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_LOWEST_PRICE = "lcf8txt49";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_NEWEST_ = "lcf8txt50";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_TIME_LEFT = "lcf8txt51";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_VIEWS = "lcf8txt52";
	public String LEGACY_ADMIN_TRANSLATIONS_SEARCH_TXT_MAX_SEARCH_REACHED = "lcf8txt53";

	// TRANSLATION LOGIN

	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_COMBINATION_NOT_FOUND = "lcf8txt1";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_INCORRECT_TEXT_ENTERED = "lcf8txt2";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_USERNAME_REQUIRED = "lcf8txt3";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_RESET_YOUR_PASSWORD = "lcf8txt4";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_USER_NAME_SENT_EMAIL = "lcf8txt5";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_LOGIN = "lcf8txt6";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_CONGRATULATION_AC_VERIFIED = "lcf8txt7";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_EMAIL_VERIFIED = "lcf8txt8";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_MISMATCHED_VERIFICATION_CODE = "lcf8txt9";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_UNKNOWN_ERROR_OCCURED = "lcf8txt10";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_LOGIN_FAILED = "lcf8txt11";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_FORGOT_PASSWORD = "lcf8txt12";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_ITS_EASY = "lcf8txt13";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_NOT_A_MEMBER_YET = "lcf8txt14";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_PASSWORD = "lcf8txt16";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_REGISTER_NOW = "lcf8txt17";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_USER_NAME = "lcf8txt18";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_LINK_EXPIRED = "lcf8txt21";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_PASSWORD_REQUIRED = "lcf8txt20";
	public String LEGACY_ADMIN_TRANSLATIONS_LOGIN_TXT_YOUR_PASSWORD_HAS_RESET = "lcf8txt23";

	// Invoice page translation

	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_YOUR_CREDIT_HAVE_BEEN_APPLIED = "lcf8txt3";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_APPLY_COUPON = "lcf8txt5";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_APPLY_CREDITS = "lcf8txt6";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_COUPON_CODE = "lcf8txt9";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_COUPON_CODE_INVALID = "lcf8txt10";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_COUPON_CODE_REQUIRED = "lcf8txt11";

	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_DATE = "lcf8txt14";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_BALANCE_DUE = "lcf8txt16";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_BILLING_INFORMATION = "lcf8txt17";

	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_BUYER_PREMIUM = "lcf8txt18";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_CATEGORY = "lcf8txt20";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_EXTRA_CHARGES = "lcf8txt22";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_HAMMER_PRICE = "lcf8txt23";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_INVOICE_HASH = "lcf8txt24";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_ITEM_NAME = "lcf8txt25";

	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_ITEM_HASH = "lcf8txt26";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_LOT_HASH = "lcf8txt28";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_NOTES = "lcf8txt29";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_PAYMENTS_MADE = "lcf8txt31";

	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_PAY_NOW = "lcf8txt32";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_QTY = "lcf8txt33";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_SALE = "lcf8txt34";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_SALE_DATE = "lcf8txt35";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_SALES_TAX = "lcf8txt37";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_SHIPPING_HANDLING = "lcf8txt38";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_SHIPPING_INFORMATION = "lcf8txt39";

	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_STATUS = "lcf8txt40";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_SUBTOTAL = "lcf8txt41";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_TOTAL_INVOICE = "lcf8txt42";

	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_INVOICE_HASH1 = "lcf8txt44";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_INVALID_CREDIT = "lcf8txt45";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_MDY = "lcf8txt46";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_ITEMS = "lcf8txt47";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_NO_ENOUGH_CREDIT = "lcf8txt49";

	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_PAY_VIA_AUTHORIZE_NET = "lcf8txt55";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_PAY_VIA_CC_EPAY = "lcf8txt57";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_PAY_VIA_PAYPAL = "lcf8txt60";

	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_PDF_INVOICE = "lcf8txt65";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_PRINTABLE_VIEW = "lcf8txt66";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_SALE_DATE_MDY = "lcf8txt69";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_SEARCH = "lcf8txt70";

	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_SHOW = "lcf8txt71";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_ALL = "lcf8txt72";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_STATUS1 = "lcf8txt76";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_PAID = "lcf8txt80";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_PENDING = "lcf8txt81";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_SHIPPED = "lcf8txt82";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_INVOICES = "lcf8txt84";
	public String LEGACY_ADMIN_TRANSLATIONS_INVOICE_TXT_TOTAL = "lcf8txt85";

	// COUPONS PAGE

	public String LEGACY_ADMIN_SETTINGS_COUPONS_PAGE_TITLE = "Manage Coupons";
	public String LEGACY_ADMIN_BTN_ADD_COUPON = "Add Coupon";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_TXT_TITLE = "clf1";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_TXT_CODE = "clf2";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_TXT_MIN_PURCHASE_AMOUNT = "clf7";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_TXT_START_DATE_PICKER = "clf3";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_TXT_END_DATE_PICKER = "clf5";
	public String LEGACY_ADMIN_SETTINGS_FIXED_AMOUNT_FIELD = "clf18";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_PERCENTAGE= "clf19";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_FIRST_OPTION = "clf23";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_SELECT_CATEGORY = "lstlc1";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_TYPE = "clf9";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_SHOW_ALL_DROPDOWN = "clf17";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_BTN_SAVE = "Save Coupon";
	public String LEGACY_ADMIN_SETTINGS_COUPONS_REQUIRED = "Title required";
	public String LEGACY_ADMIN_SETTINGS_AMOUNT_REQUIRED = "Amount required";
	public String LEGACY_ADMIN_SETTINGS_PERCENTAGE_VALIDATION = "Percentage should be positive number or zero";
	public String LEGACY_ADMIN_SETTINGS_PERCENTAGE_VALIDATION_QA3_6_AUTO = "Percentage should be numeric";
	public String LEGACY_ADMIN_SETTINGS_AMOUNT_REQUIRED_TITLE_LENGTH_LIMIT_REACHED_50_CHARACTERS = "Title length limit reached (50) characters";


	// new account
	public String LEGACY_ADMIN_ACCOUNT_NAME = "spaf2";
	public String LEGACY_ADMIN_SAVE_ACCOUNT = "spaf12";
	
	// String for Xpath
	public String LEGACY_AUCTION_MENU = "//div[@class='tab-menu']//a[contains(text(),' Auction')]";
	public String LEGACY_AUCTION_GENERAL_SECTION = "//div[@class='legend_div'][text()='General ']//a";
	public String LEGACY_ADMIN_USERS_PAGE = "//div[@id='welcome']//a[@title='Users']";
	public String LEGACY_SELECT_BIDDER = "//td[@class='row0-ab13 ab13-col0  first']//..//input[@type='checkbox']";
	public String LEGACY_APPROVE_BIDDER = "//td[@class='row0-ab4 ab4-col0  first']//..//a[@class='bidderapprove']";
	public String LEGACY_ADMIN_AUCTION_PAGE = "//div[@id='welcome']//a[@title='Auctions']";
	public String LEGACY_ADMIN_SUCCESS_MESSAGE = "//p[@class='alert alert-success']";
	public String LEGACY_MANAGE_INVENTORY_PAGE = "//div[@id='welcome']//a[text()='Inventory']";
	public String LEGACY_ADMIN_VALIDATION_MESSAGE = "//span[text()='Error found at row 1: Name* required']";
	
	//Feeds
	public String LEGACY_SETTINGS_MANAGE_FEEDS = "Manage Feeds";
	public String LEGACY_SETTINGS_ADD_FEEDS = "spmflf1";
	public String LEGACY_SETTINGS_SELECT_CURRENCY_FROM_DROPDOWN = "spmfef23";
	public String LEGACY_SETTINGS_FEED_NAME = "spmfef1";
	public String LEGACY_SETTINGS_SLUG = "spmfef2";
	public String LEGACY_SETTINGS_FEED_TYPE = "spmfef3";
	public String LEGACY_SETTINGS_INCLUDE_IN_REPPORT_CHECKBOX = "spmfef25";
	public String LEGACY_SETTINGS_CACHED_TIMEOUT = "spmfef10";
	public String LEGACY_SETTINGS_ITEMS_PER_PAGE = "spmfef11";
	public String LEGACY_SETTINGS_ESCAPING = "spmfef12";
	public String LEGACY_SETTINGS_FILE_NAME = "spmfef27";
	public String LEGACY_SETTINGS_FILE_HEADER = "spmfef4";
	public String LEGACY_SETTINGS_FILE_REPETATION = "spmfef5";
	public String LEGACY_SETTINGS_FILE_FOOTER = "spmfef6";
	public String LEGACY_SETTINGS_NAME_REQUIRED = "Name required";
	public String LEGACY_SETTINGS_SAVE_FEED_BTN = "spmfef8";
	public String LEGACY_SETTINGS_VALIDATION_100_CHARACTER_LIMIT = "100 symbols length is name limit";
	public String LEGACY_SETTINGS_WARNING_MESSAGE = "warning";
	// ---------------------------------------------------------------------------------------------

	@FindBy(xpath = "//input[@id='usr']")
	protected WebElement usernameInputID;

	@FindBy(xpath = "//input[@type='submit']")
	protected WebElement submitbutton;

	@FindBy(xpath = "//a[@id='btnE2']")
	protected WebElement editTemplate;

	@FindBy(xpath = "//a[text()='Auctions']")
	protected WebElement AuctionMenu;

	@FindBy(xpath = "//*[text()='Auctions']")
	protected WebElement resopnsiveauctionmenu;

	@FindBy(xpath = "//input[@id='aef3']")
	protected WebElement publishauctionCheckbox;

	@FindBy(xpath = "//a[@title='Run Live Auction']")
	protected WebElement runLiveAuction;

	@FindBy(xpath = "//input[@id='pip1']")
	protected WebElement signupUsername;

	@FindBy(xpath = "//input[@id='pip2']")
	protected WebElement signupPassword;

	@FindBy(xpath = "//*[@id='pip3']")
	protected WebElement signupConfirm;

	@FindBy(xpath = "//*[@id='pip6']")
	protected WebElement signupEmail;

	@FindBy(xpath = "//*[@id='pip4']")
	protected WebElement signupFirstname1;

	@FindBy(xpath = "//*[@id='pip5']")
	protected WebElement signupLastname;

	@FindBy(xpath = "//a[@id='bpepip9']")
	protected WebElement editBoxOfPhone;

	@FindBy(xpath = "//select[@id='pip11']//option[text()='-Select-']")
	protected WebElement signupPhoneType;

	@FindBy(xpath = "//select[@id='rbp25']//option[text()='-Select-']")
	protected WebElement signupContactType;

	@FindBy(xpath = "//select[@id='pip13']//option[text()='-Select-']")
	protected WebElement signupIdentificationType;

	@FindBy(xpath = "//select[@id='pip14']//option[text()='-Select-']")
	protected WebElement editPhoneType;

	@FindBy(xpath = "//*[@id='rbp3']")
	protected WebElement signupBillFirstname;

	@FindBy(xpath = "//*[@id='rbp4']")
	protected WebElement signupLastName;

	@FindBy(xpath = "//a[@id='bperbp5']")
	protected WebElement signupPhone;

	@FindBy(xpath = "//span[@id='pip11_ctl']/select[@id='pip11']")
	protected WebElement selectNew;

	@FindBy(xpath = "//span[@id='pip13_ctl']/select[@id='pip13']")
	protected WebElement identificationtype;

	@FindBy(xpath = "//input[@id='rf1']")
	protected WebElement terms;

	@FindBy(xpath = "//input[@value='Signup']")
	protected WebElement signUp;

	@FindBy(xpath = "//*[@id='sip1']")
	protected WebElement ship;

	@FindBy(xpath = "//tr[@id='alf4row0']//a[@class='editlink']")
	protected WebElement Editauction;

	@FindBy(xpath = "//input[@id='c51']")
	protected WebElement uploadSettlement;

	@FindBy(xpath = "//input[@id='c32']")
	protected WebElement uploadInvoice;

	@FindBy(xpath = "//a[@id='c8']")
	protected WebElement uploadLayout;

	@FindBy(xpath = "//input[@id='c3']")
	protected WebElement chooseFile;

	@FindBy(xpath = "//input[@id='c12']")
	protected WebElement chooseFile2;

	@FindBy(xpath = "//input[@id='c21']")
	protected WebElement chooseFile3;

	@FindBy(xpath = "//div[@id='dlgFileAsset_scf3']//input[@id='c14']")
	protected WebElement chooseFile4;

	@FindBy(xpath = "//h1[contains(text(),'Upload a File')]//..//..//..//..//input[@type='file']")
	protected WebElement chooseFile5;

	@FindBy(xpath = "//*[@id='bpspip9']")
	protected WebElement phoneOk;

	@FindBy(xpath = "//*[@id='bpsrbp5']")
	protected WebElement billPhoneOk;

	@FindBy(xpath = "//div[@class='legend_div']//a[@class='sett close']")
	protected WebElement expandsettlement;

	@FindBy(xpath = "//span[@id='rbp25_ctl']/select[@id='rbp25']")
	protected WebElement billingInfoSelect;

	@FindBy(xpath = "//span[@id='rbp13_ctl']/select[@id='rbp13']")
	protected WebElement signupcc;

	@FindBy(xpath = "//*[@id='pbp13_ctl']/select[@id='pbp13']")
	protected WebElement editsignupcc;

	@FindBy(xpath = "//span[@id='rbp15_ctl']/select[@id='rbp15']")
	protected WebElement signupmonth;

	@FindBy(xpath = "//*[@id='rbp15_ctl']/select[@id='rbp15']")
	protected WebElement signupccmonth;

	@FindBy(xpath = "//*[@id='c7_ctl']/select[@id='c7']")
	protected WebElement editexpirationmonth;
	
	@FindBy(xpath = "//span[@class='arrow']//a[text()='Next']")
	protected WebElement changepage;
	
	@FindBy(xpath = "//div[@class='right pagintn']//span[text()='Next']")
	protected WebElement Nextpage;

	@FindBy(xpath = "//a[contains(text(),'Live auction')]")
	protected WebElement LiveAuction;

	@FindBy(xpath = "//div[@class='tab-menu']//ul//li//a[contains(text(),'Auction')]")
	protected WebElement auction;

	@FindBy(xpath = "//span[@id='c3_ctl']/select[@id='c3']")
	protected WebElement signupyear;

	@FindBy(xpath = "//span[@id='c8_ctl']/select[@id='c8']")
	protected WebElement editexpirationyear;

	@FindBy(xpath = "//span[@id='rbp20_ctl']/select[@id='rbp20']")
	protected WebElement bankaccounttype;

	@FindBy(xpath = "//input[@id='c5']")
	protected WebElement signup;

	@FindBy(xpath = "//div[@class='lot-bidding']//..//div[@class='place-bid']//..//button[@id='z17']")
	protected WebElement bidbutton;

	@FindBy(xpath = "//span[@id='aof70_ctl']")
	protected WebElement Confirmmultipletimedandliveabsenteebids;

	@FindBy(xpath = "//span[@id='rbp7_ctl']/select[@id='rbp7']")
	protected WebElement countryselection;

	@FindBy(xpath = "//*[@id='pbp30_ctl']/select[@id='pbp30']")
	protected WebElement editbillingcontacttype;

	@FindBy(xpath = "//*[@id='pbp11_ctl']/select[@id='pbp11']")
	protected WebElement editbillingstate;

	@FindBy(xpath = "//*[@id='pbp7_ctl']/select[@id='pbp7']")
	protected WebElement editbillingcoutry;

	@FindBy(xpath = "//span[@id='psp7_ctl']/select[@id='psp7']")
	protected WebElement editshippingcountryselection;

	@FindBy(xpath = "//span[@id='psp12_ctl']/select[@id='psp12']")
	protected WebElement editshippingstateselection;

	@FindBy(xpath = "//span[@id='sip11_ctl']/select[@id='sip11']")
	protected WebElement shippingstateselection;

	@FindBy(xpath = "//*[@id='sip7_ctl']/select[@id='sip7']")
	protected WebElement shippingcountryselection;

	@FindBy(xpath = "//span[@id='rbp11_ctl']/select[@id='rbp11']")
	protected WebElement stateselection;
	
	@FindBy(xpath = "//a[text()='Signup']")
	protected WebElement signUpLink;
	
	@FindBy (xpath = "//div[@class='legend_div'] [text()='Catalog ']//a[@class='close']")
	protected WebElement catalogsetting;
	
	@FindBy(xpath = "//select[@id ='alf3']")
	protected WebElement selectauctiontype;

	@FindBy(xpath = "//select[@id ='alf9']")
	protected WebElement auctiioneer;

	@FindBy(xpath = "//a[text()='Logout']//..//p")
	protected WebElement logout;

	@FindBy(xpath = "//select[@name='alf1']//option[text()='Bidding now and upcoming']")
	protected WebElement biddingNowUpcoming;

	@FindBy(xpath = "//span[@id='c3_ctl']//a[text()='Next']")
	protected WebElement nextbutton;

	@FindBy(xpath = "//a[text()='Live Sale ']")
	protected WebElement liveSale;
	
	@FindBy(xpath = "//span[@class='edit-link']//a[text()='Edit']")
	protected WebElement editicon;
	
	@FindBy(xpath = "//div[@class='tab-menu']//a[contains(text(),' Auction')]")
	protected WebElement Auctionsmenu;
	
	@FindBy(xpath = "//a[contains(text(),'Live Sale')]")
	protected WebElement liveSaleTab;
	
	@FindBy(xpath = "//body/div[@id='wrapper']/div[1]/ol[1]/li[3]/a[1]/span[1]")
	protected WebElement liveSaleName;
	
	@FindBy(xpath = "//a[contains(text(),'View live sale now!')]")
	protected WebElement Viewlivesalenow;

	@FindBy(xpath = "//tr[@id='lac5row0']//input[@type='checkbox']")
	protected WebElement lotCheckCheckbox;

	@FindBy(xpath = "//legend[text()='User information ']//a")
	protected WebElement userinformation;

	@FindBy(xpath = "//input[@id='btnSave']")
	protected WebElement savechanges;
	
	@FindBy(xpath = "//tr[@id='alf5row0']//a[@class='deletelink']")
	protected WebElement deletefirstlot;
	
	@FindBy(xpath = "//div[@id='welcome']//a[text()='Inventory']")
	protected WebElement Inventorypage;

	@FindBy(xpath = "//input[@id='btnSave']")
	protected WebElement savechangesUser;

	@FindBy(xpath = "//table[@id='slf5']//tr[@id='slf5row0']//a[@class='editlink']")
	protected WebElement editSettlement;

	@FindBy(xpath = "//tbody/tr[@id='dtgSettlementCheckListrow0']/td[16]/a[1]")
	protected WebElement editCheck;
	
	@FindBy(xpath = "//div[@class='legend_div'] [text()='General ']//a")
	protected WebElement general;
	
	@FindBy(xpath = "//div[@class='legend_div'] [text()='Registration']//a")
	protected WebElement auctionregistration;

	@FindBy(xpath = "//a[contains(text(),'Invoicing')]")
	protected WebElement InvoicePayments;

	@FindBy(xpath = "//a[contains(text(),'Payments')]")
	protected WebElement Payments;

	@FindBy(xpath = "//th[@id='ipf11_rowh_0']//..//span")
	protected WebElement nameSorting_currency;

	@FindBy(xpath = "//a[@class='cur close']")
	protected WebElement Currencies;

	@FindBy(xpath = "//a[@title='Manage Bid Increments']")
	protected WebElement BidIncrements;

	@FindBy(xpath = "//a[contains(text(),'Timed')]")
	protected WebElement Timedsale;

	@FindBy(xpath = "//a[contains(text(),'Timed online auction')]")
	protected WebElement TimedOnlineOptions;

	@FindBy(xpath = "//div[@class='calendar'][@style='position: absolute; display: block; left: 0px; top: 465px; z-index: 99999;']//td[@class='day selected today']")
	protected WebElement selectTodayDate;

	@FindBy(xpath = ".//*[@id='bshowpop']")
	protected WebElement Showinpopup;

	@FindBy(xpath = "//a[@id='bshowpopsimp']")
	protected WebElement Showinpopupsimplified;

	@FindBy(xpath = "//input[@id='btnSave']")
	protected WebElement savechange;

	@FindBy(xpath = "//a[@title='Auction projector']")
	protected WebElement Projector;

	@FindBy(xpath = "//button[@id='btnStartAuction']")
	protected WebElement Start_Auction;

	@FindBy(xpath = "//div[text()='My Items ']//..//a")
	protected WebElement MyItem;

	@FindBy(xpath = ".//*[@id='asf8']")
	protected WebElement Simultenious;

	@FindBy(xpath = "//input[@id='asf1']")
	protected WebElement auctionsettingSavechagnes;

	@FindBy(xpath = "//tr[@id='alf5row0']//a[@title='Preview']")
	protected WebElement lotpreview1;

	@FindBy(xpath = "//*[@id='asf13']")
	protected WebElement CancelGroup;

	@FindBy(xpath = "//*[@id='auction-search']/form/input[2]")
	protected WebElement Search;

	@FindBy(xpath = "//div[@class='user-form']/fieldset/legend/a[@class='close user-info']")
	protected WebElement UserInformation;
	
	@FindBy(xpath = "//a[@class='user-info close']")
	protected WebElement ExpandUserInformationtab;

	@FindBy(xpath = "//input[@id='asf11[0]']")
	protected WebElement SelectFirstElement;

	@FindBy(xpath = "//button[@value='Group(All4One)']")
	protected WebElement GroupAllone;

	@FindBy(xpath = "//input[@id='tacf3']")
	protected WebElement SaveSiteContent;

	@FindBy(xpath = "//a[@title='Manage Site Content']")
	protected WebElement SiteContent;

	@FindBy(xpath = "//input[@id='asf12']")
	protected WebElement update;

	@FindBy(xpath = "//a[@id='asf9']")
	protected WebElement Edit;

	@FindBy(xpath = "//tr[@id='ulf10row0']//td[1]//..//a[contains(text(),'edit')]")
	protected WebElement editUser;
	
	@FindBy(xpath = "//a[contains(text(),'Categories')]")
	protected WebElement newcategories;


	@FindBy(xpath = "//input[@id='asf1']")
	protected WebElement Auctionsave;
	
	@FindBy(xpath = "//input[@id='ubuyprem3']")
	protected WebElement addlivebp;

	@FindBy(xpath = "//input[@id='ulf28']")
	protected WebElement autocheckon;

	@FindBy(xpath = "//input[@id='aef3']")
	protected WebElement Publish;

	@FindBy(xpath = "//a[text()='Auctions'][1]")
	protected WebElement auctionview;

	@FindBy(xpath = "//a[text()='Auctions']")
	protected WebElement auctionsubtab;
	
	@FindBy(xpath = "//table[@id='ab4']//tr//td[text()='rahul sharma']//..//a[text()='approve']")
	protected WebElement ApproveBidder;
	
	@FindBy(xpath = "//a[contains(text(),'<<Back to auction lot list')]")
	protected WebElement Backtolotlist;
	
	@FindBy(xpath = "//input[@id='ulf15']")
	protected WebElement uploadbidderbutton;

	@FindBy(xpath = "//a[text()='Users options']")
	protected WebElement Useroption;

	@FindBy(xpath = "//a[@title='Users']")
	protected WebElement user;

	@FindBy(xpath = "//input[@id='ulf9']")
	protected WebElement adduser;

	@FindBy(xpath = "//a[@class='items close']")
	protected WebElement maixmizeUserSection;

	@FindBy(xpath = "//input[@id='btnSave']")
	protected WebElement save;

	@FindBy(xpath = "//input[@id='scf1']")
	protected WebElement catlogsavechanges;
	
	@FindBy(xpath = "//form[@id='AdvancedSearch']//div[1]//article[1]//section[1]//div[5]//div[1]//a[2]")
	protected WebElement view;
	
	@FindBy(xpath = "//li[@id='lot1']//label[1]")
	protected WebElement addtowatchlist;
	
	@FindBy(xpath = "//a[contains(text(),'<<Back to list')]")
	protected WebElement Backtolist;

	@FindBy(xpath = "//input[@id='ulf15']")
	protected WebElement uploadauctionbidder;

	@FindBy(xpath = "//tr[@id='alf5row0']//a[@class='editlink']")
	protected WebElement editfirstlot;

	@FindBy(xpath = "//div[@class='legend_div'][text()='Registration Settings']//a")
	protected WebElement UserInfo;

	@FindBy(xpath = "//div[@class='user-form']//fieldset//legend[text()='Billing information ']//a")
	protected WebElement BillingInfo;

	@FindBy(xpath = "//div[@id='welcome']//a[contains(text(),'Settings')]")
	protected WebElement settings;

	@FindBy(xpath = "//a[contains(text(),'Accounts')]")
	protected WebElement Accounts;

	@FindBy(xpath = "//input[@id='spaf1']")
	protected WebElement Addnewaccount;

	@FindBy(xpath = "//div[@id='welcome']//a[contains(text(),'Auctions')]")
	protected WebElement auctions;

	@FindBy(xpath = "//legend[text()='Language to use: ']")
	protected WebElement languageToUse;

	@FindBy(xpath = "//a[text()='Invoices']")
	protected WebElement Invoices;

	@FindBy(xpath = "//div[@id='welcome']//a[@title='Users']")
	protected WebElement users;

	@FindBy(xpath = "//a[contains(text(),'Payment')]")
	protected WebElement payment;

	@FindBy(xpath = "//span[text()='cat1']//..//a[@class='deleteCategoryLink deletelink']")
	protected WebElement deleteCat1;
	@FindBy(xpath = "//span[text()='cat2']//..//a[@class='deleteCategoryLink deletelink']")
	protected WebElement deleteCat2;
	@FindBy(xpath = "//span[text()='cat3']//..//a[@class='deleteCategoryLink deletelink']")
	protected WebElement deleteCat3;
	@FindBy(xpath = "//span[text()='cat4']//..//a[@class='deleteCategoryLink deletelink']")
	protected WebElement deleteCat4;
	@FindBy(xpath = "//span[text()='cat5']//..//a[@class='deleteCategoryLink deletelink']")
	protected WebElement deleteCat5;
	@FindBy(xpath = "//span[text()='cat6']//..//a[@class='deleteCategoryLink deletelink']")
	protected WebElement deleteCat6;

	@FindBy(xpath = "//a[contains(text(),'System Parameters')]")
	protected WebElement managesystemparameters;

	@FindBy(xpath = "//select[@id='ilf18']")
	protected WebElement selectuser;

	@FindBy(xpath = "//tr[@id='ilf5row0']//a[@class='editlink'][contains(text(),'edit')]")
	protected WebElement editInvoice;

	@FindBy(xpath = "//tbody/tr[@id='slf5row0']/td[16]/a[1]")
	protected WebElement editsettlement;

	@FindBy(xpath = "//td[contains(text(),'Created')]//..//..//a[text()='Delete']")
	protected WebElement deletechecks;

	@FindBy(xpath = "//input[@id='iid34']")
	protected WebElement editInInvoice;
	
	@FindBy(xpath = "//input[@id='al121']")
	protected WebElement SearchButton;

	@FindBy(xpath = "//input[@id='iid35']")
	protected WebElement saveEdit;

	@FindBy(xpath = "//a[contains(text(),'Live / Hybrid auctions')]")
	protected WebElement Liveauction;

	@FindBy(xpath = "//input[@id='uof1']")
	protected WebElement savechanges_uof1;

	@FindBy(xpath = "//input[@id='scf1']")
	protected WebElement savechanges1;
	
	@FindBy(xpath = "//input[@id='pf1']")
	protected WebElement savepaymentchanges;

	@FindBy(xpath = "//div[text()='Clerking UI ']")
	protected WebElement ClerkingUI;

	@FindBy(xpath = "//fieldset[@class='section-commissions-and-charges']")
	protected WebElement MaxCommision;

	@FindBy(xpath = "//div[@class='legend_div']//..//div[text()='Live Auction Chat ']//a")
	protected WebElement LiveAuctionChat;

	@FindBy(xpath = "//span[contains(text(),'Sound Settings')]//..//a[@class='close']")
	protected WebElement SoundSettings;

	@FindBy(xpath = "//div[@class='legend_div'] [text()='Permissions ']//a")
	protected WebElement permissions;

	@FindBy(xpath = "//fieldset[@class='section-registration']//div[contains(text(),'Registration')]")
	protected WebElement registrationsettingsmaximize;

	@FindBy(xpath = "//div[@class='legend_div'] [text()='PayPal ']//a")
	protected WebElement paypalsettingmaximize;

	@FindBy(xpath = "//input[@id='ipf30']")
	protected WebElement enablepaypalpayment;
	
	@FindBy(xpath = "//input[@id='liupt1']")
	protected WebElement uploadlotbutton;

	@FindBy(xpath = "//input[@id='uof2']")
	protected WebElement simplifiedsignuppage;

	@FindBy(xpath = "//input[@id='uof10']")
	protected WebElement verifyemailuponaccountregistration;

	@FindBy(xpath = "//input[@id='uof11']")
	protected WebElement verifycreditcardsignup;

	@FindBy(xpath = "//input[@id='uof13a']")
	protected WebElement donotmakeuserbidderonsignup;

	@FindBy(xpath = "//input[@id='ab5']")
	protected WebElement checkallonthispage;

	@FindBy(xpath = "//input[@id='ab6']")
	protected WebElement removecheckuser;

	@FindBy(xpath = "//tr[@id='slf5row0']//td[16]//a[@class='editlink']")
	protected WebElement viewsettlement;

	@FindBy(xpath = "//input[@id='uof14']")
	protected WebElement AutoassignPreferredbidderprivilegesuponsignup;

	@FindBy(xpath = "//input[@id='uof51']")
	protected WebElement AutoassignPreferredbidderprivilegesuponcreditcardupdate;

	@FindBy(xpath = "//input[@id='uof53']")
	protected WebElement RevokePreferredbidderprivilegesifCCexpiredmissing;

	@FindBy(xpath = "//input[@id='uof13']")
	protected WebElement EnableResellerRegistration;

	@FindBy(xpath = "//input[@id='uof16']")
	protected WebElement Enableconsignorpaymentinfo;

	@FindBy(xpath = "//input[@id='uof17']")
	protected WebElement Makeoptionalinprofile;

	@FindBy(xpath = "//input[@id='uof19']")
	protected WebElement Requireaddressconfirmationuponsaleregistration;

	@FindBy(xpath = "//input[@id='uof20']")
	protected WebElement Requireconfirmationofsaletermsconditionsuponsaleregistration;

	@FindBy(xpath = "//input[@id='uof59']")
	protected WebElement Enablecompanyname;
	
	@FindBy(xpath = "//input[@id='uof78']")
	protected WebElement EnableCountryCodeSelection;

	@FindBy(xpath = "//input[@id='uof66']")
	protected WebElement Includeuserpreferences;

	@FindBy(xpath = "//input[@id='uof67']")
	protected WebElement RequireIdentification;

	@FindBy(xpath = "//input[@id='uof68']")
	protected WebElement Agentoption;

	@FindBy(xpath = "//input[@id='uof70']")
	protected WebElement Autoincrementcustomer;

	@FindBy(xpath = "//input[@id='uof71']")
	protected WebElement Makepermanentbidder;
	
	@FindBy(xpath = "//a[@class='bidderapprove']")
	protected WebElement bidderapprove;

	@FindBy(xpath = "//input[@id='uof75']")
	protected WebElement Autoassignconsignorprivileges;

	@FindBy(xpath = "//input[@id='uof78']")
	protected WebElement HideCountryCodeSelection;

	@FindBy(xpath = "//input[@id='uof76']")
	protected WebElement Autoassignaccountadminprivileges;

	@FindBy(xpath = "//a[text()='Logout']")
	protected WebElement adminLogout;

	@FindBy(xpath = "//input[@id='alf2']")
	protected WebElement createnewauction;

	@FindBy(xpath = "//a[@title='Reset']")
	protected WebElement resetauction;

	@FindBy(xpath = "//tr[@id='alf5row0']//td[31]//a[@title='Edit']")
	protected WebElement Editlot;

	@FindBy(xpath = "//a[@id='sectionItems2']")
	protected WebElement expandavailableitems;
	
	@FindBy(xpath = "//a[@title='Delete']")
	protected WebElement deletelot;

	@FindBy(xpath = "//input[@class='button'][@name='alf2']")
	protected WebElement createnewauction_time_online;

	@FindBy(xpath = "//span[@id='aip0_ctl']/select[@id='aip0']")
	protected WebElement auctiontype;

	@FindBy(xpath = "//span[@id='alf1_ctl']//select[@id='alf1']")
	protected WebElement showtype;

	@FindBy(xpath = "//span[@id='alf16_ctl']//select[@id='alf16']")
	protected WebElement showtype1;

	@FindBy(xpath = "//span[@id='alf18_ctl']//select[@id='alf18']")
	protected WebElement showtype2;

	@FindBy(xpath = "//span[@id='alf80_ctl']//select[@id='alf80']")
	protected WebElement showtype3;

	@FindBy(xpath = "//input[@id='aip35_0']")
	protected WebElement clerking;

	@FindBy(xpath = "//input[@id='aip35_1']")
	protected WebElement clerkingadvance;

	@FindBy(xpath = "//input[@id='aef3']")
	protected WebElement publish;

	@FindBy(xpath = "//input[@id='aef5']")
	protected WebElement newauctionsavechanges;
	
	@FindBy(xpath = "//button[@value='Start Auction!']")
	protected WebElement StartAuctionbutton;

	@FindBy(xpath = "//input[@id='upload_auction_image']")
	protected WebElement choosefileAuction;

	@FindBy(xpath = "//div[@id='tab-sub-menu']//a[text()='Settings']")
	protected WebElement auctionsetting;

	@FindBy(xpath = "//a[@id='asf9']")
	protected WebElement edit;
	
	@FindBy(xpath = "//td[@class='row0-alf5 alf5-col31 li-select last']//span[@class='qcheckbox-ctl']//input[@type='checkbox']")
    protected WebElement selectauclot;

	@FindBy(xpath = "//a[contains(text(),'1 x1 - 2014-12-31 10:57:16')]/../../..//input[@id='asf11[5]']")
	protected WebElement auctiongroup2;

	@FindBy(xpath = "//input[@id='asf12']")
	protected WebElement updateinfo;

	@FindBy(xpath = "//input[@id='asf1']")
	protected WebElement saveChangeupdate;

	@FindBy(xpath = "//a[contains(text(),'Lots')]")
	protected WebElement auctionlots;

	@FindBy(xpath = "//input[@id='liup1']")
	protected WebElement browsecsv;

	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/form[1]/div[2]/div[4]/div[1]/fieldset[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[19]/a[1]")
	protected WebElement editInvoice2;

	@FindBy(xpath = "//tbody/tr[@id='ilf5row0']/td[19]/a[1]")
	protected WebElement editInvoiceAny;
	
	@FindBy(xpath = "//tr[@id='alf5row0']//a[contains(text(),'edit')]")
	protected WebElement editlot;
	
	@FindBy(xpath = "//input[@value='Quick Edit'][@name='alf99qe']")
	protected WebElement quickeditlot;

	@FindBy(xpath = "//input[@id='luip17']")
	protected WebElement browseCSVuser;

	@FindBy(xpath = "//a[@class='editlink']")
	protected WebElement editLot;

	@FindBy(xpath = "//input[@id='alf3']")
	protected WebElement addLot;

	@FindBy(xpath = "//input[@id='lid6']")
	protected WebElement saveandexit;

	@FindBy(xpath = "//a[text()='Add custom increments']")
	protected WebElement increment_add;

	@FindBy(xpath = "//input[@id='ulf9']")
	protected WebElement AddUsers;

	@FindBy(xpath = "//a[@class='close user-info']")
	protected WebElement closeuserinfo;

	@FindBy(xpath = "//a[@class='close user-billing']")
	protected WebElement closebillinfo;

	@FindBy(xpath = "//input[@id='uof31']")
	protected WebElement includebasicinfo;

	@FindBy(xpath = "//input[@id='uof16']")
	protected WebElement enableConsignor;

	@FindBy(xpath = "//input[@id='uof32']")
	protected WebElement makebasicinfomandatory;

	@FindBy(xpath = "//input[@id='uof33']")
	protected WebElement includeBillingInfo;


	@FindBy(xpath = "//input[@id='uof34']")
	protected WebElement makeBillingAddressInfoMandatory;

	@FindBy(xpath = "//a[text()='Home']")
	protected WebElement homebutton;

	@FindBy(xpath = "//input[@id='uof35']")
	protected WebElement includeccinfo;

	@FindBy(xpath = "//input[@id='uof36']")
	protected WebElement makeccinfomandatory;

	@FindBy(xpath = "//input[@id='uof37']")
	protected WebElement includeACHinfo;

	@FindBy(xpath = "//span[@id='rbp7_ctl']//a[@class='sbToggle']")
	protected WebElement Selectcountry;

	@FindBy(xpath = "//span[@id='rbp7_ctl']//..//a[contains(text(),'Canada')]")
	protected WebElement SelectCanada;

	@FindBy(xpath = "//input[@id='uof38']")
	protected WebElement makeachinfo;

	@FindBy(xpath = "//input[@id='uof13']")
	protected WebElement enablereseller;

	@FindBy(xpath = "//input[@id='uof10']")
	protected WebElement enableemailaccout;

	@FindBy(xpath = "//input[@id='uof11']")
	protected WebElement enablecreditcardonsignup;

	@FindBy(xpath = "//span[@id='uof63_ctl']/select[@id='uof63']")
	protected WebElement select;

	@FindBy(xpath = "//*[@id='rbp13_ctl']/select[@id='rbp13']")
	protected WebElement selectcctype;

	@FindBy(xpath = "//*[@id='rbp20_ctl']/select[@id='rbp20']")
	protected WebElement selectbankactype;

	@FindBy(xpath = "//span[@id='UsrCustFldEdt524_ctl']//option[text()='-Select-']")
	protected WebElement selectusrrole;

	@FindBy(xpath = "//input[@id='uof14']")
	protected WebElement bidderprivilegesuponsignup;

	@FindBy(xpath = "//a[contains(text(),'Bid Increments')]")
	protected WebElement BidIncrement;

	@FindBy(xpath = "//input[@id='liup1']")
	protected WebElement BrowseCSV;

	@FindBy(xpath = "//input[@id='alf13']")
	protected WebElement SearchSale;

	@FindBy(xpath = "//button[text()='Start auction!']")
	protected WebElement startauctionbutton;
	
	@FindBy(xpath = "//button[@id='btnAcceptBid']")
	protected WebElement acceptonlinebid;
	
	@FindBy(xpath = "//button[@id='btnSold']")
	protected WebElement soldbutton;

	@FindBy(xpath = "//a[@title='Auction Specific Settings']")
	protected WebElement auctionsettings;

	@FindBy(xpath = "//button[@id='btnFloorBid']")
	protected WebElement postFloorBid;

	@FindBy(xpath = "//*[@id='btnSendMessage']")
	protected WebElement sendchatmessage;

	@FindBy(xpath = "//*[@id='z31']")
	protected WebElement sendchatmessagefromuser;

	@FindBy(xpath = "//*[@id='z38']")
	protected WebElement selectbidder;

	@FindBy(xpath = "//a[@title='Run Live Auction']")
	protected WebElement runliveaution;

	@FindBy(xpath = "//a[@title='Invoices']")
	protected WebElement invoices;

	@FindBy(xpath = "//a[text()='approve']")
	protected WebElement approveBidder;

	@FindBy(xpath = "//li[@class='login']")
	protected WebElement loginlink;

	@FindBy(xpath = "//header//a[text()='Profile']")
	protected WebElement selectprofile;

	@FindBy(xpath = "//*[@id='uof59']")
	protected WebElement enablecompanyname;

	@FindBy(xpath = "//span[@id='sip15_ctl']/select[@id='sip15']")
	protected WebElement shippingContactType;

	@FindBy(xpath = "//input[@id='psp36']")
	protected WebElement remembershippinginfo;

	@FindBy(xpath = "//a[contains(text(),'Custom Fields')]")
	protected WebElement customfield;

	@FindBy(xpath = "//div[text()='Additional confirmations (one per line) ']")
	protected WebElement AdditionalConf;

	@FindBy(xpath = "//*[@id='ucfe3']//option[text()='-Select-']")
	protected WebElement customtype;

	@FindBy(xpath = "//div[text()='customFiled1'':']//..//span[text()='-Select-']")
	protected WebElement customtype1;

	@FindBy(xpath = "//*[@id='ucfe4']//option[text()='-Select-']")
	protected WebElement selectpanel;

	@FindBy(xpath = "//a[@id='asf9']")
	protected WebElement editSaleGroup;

	@FindBy(xpath = "//*[@id='ucfe5']")
	protected WebElement required;
	
	@FindBy(xpath = "//input[@id='lcfe3']")
	protected WebElement showonlotlistingpage;
	
	@FindBy(xpath = "//input[@id='lcfe20']")
	protected WebElement searchindex;
	
	@FindBy(xpath = "//input[@id='lcfe18']")
	protected WebElement searchableinadmin;
	
	@FindBy(xpath = "//input[@id='lcfe4']")
	protected WebElement searchfield;

	@FindBy(xpath = "//*[@id='ucfe7']")
	protected WebElement registration;

	@FindBy(xpath = "//*[@id='ucfe8']")
	protected WebElement profile;

	@FindBy(xpath = "//*[@id='ucfe9']")
	protected WebElement inadminsearch;

	@FindBy(xpath = "//*[@id='ucfe10']")
	protected WebElement includeoninvoices;
	
	@FindBy(xpath = "//input[@id='lcfe16']")
	protected WebElement includeoninvoiceslotitempage;

	@FindBy(xpath = "//*[@id='ucfe14']")
	protected WebElement includeonsettlements;
	
	@FindBy(xpath = "//input[@id='lcfe24']")
	protected WebElement includeonsettlementslotitempage;


	@FindBy(xpath = "//tr[@id='slf5row0']/td[1]//input[@class='settlement']")
	protected WebElement checkox1;

	@FindBy(xpath = "//tr[@id='slf5row1']/td[1]//input[@class='settlement']")
	protected WebElement checkox2;

	@FindBy(xpath = "//input[@id='lcfe19']")
	protected WebElement includeinadmin;
	
	@FindBy(xpath = "//*[@id='ucfe15']")
	protected WebElement includeonaddnewbidderscreen;

	@FindBy(xpath = "//div[@class='legend_div'] [text()='Authorize.Net ']//a")
	protected WebElement Authorize_netsettingmaximize;

	@FindBy(xpath = "//input[@id='ipf38']")
	protected WebElement enableCCpayment;

	@FindBy(xpath = "//input[@id='ipf52']")
	protected WebElement enableuseauthorizenetcim;

	@FindBy(xpath = "//input[@id='ipf36']")
	protected WebElement enableACHpayment;

	@FindBy(xpath = "//input[@id='ipf73']")
	protected WebElement authorizenonpaymenttransaction;

	@FindBy(xpath = "//input[@id='ipf178']")
	protected WebElement nmicustomermanagement;

	@FindBy(xpath = "//input[@id='ipf180']")
	protected WebElement nmiEnableccpayments;

	@FindBy(xpath = "//input[@id='ipf181']")
	protected WebElement nmienableachpayments;

	@FindBy(xpath = "//input[@id='ipf179']")
	protected WebElement nmifornonpaymenttransaction;

	@FindBy(xpath = "//input[@id='lip30']")
	protected WebElement clickonbuynow;

	@FindBy(xpath = "//a[@style='background-position: 0px 0px;']")
	protected WebElement expandsearch;

	@FindBy(xpath = "//input[@id='bilf6']")
	protected WebElement Savebutton;

	@FindBy(xpath = "//input[@value='Save changes']")
	protected WebElement Savebutton_1;

	@FindBy(xpath = "//input[@id='bp4']")
	protected WebElement BuyerPremium_Save;

	@FindBy(xpath = "//input[@value='Save changes']")
	protected WebElement Savebutton_Change;

	@FindBy(xpath = "//input[@class='button'][@value='Remove']")
	protected WebElement Removebutton;

	@FindBy(xpath = "//input[@id='bilf5']")
	protected WebElement Addbutton;

	@FindBy(xpath = "//input[@id='bp5']")
	protected WebElement addbutton_time;

	@FindBy(xpath = "//input[@value='Add new']")
	protected WebElement Addbutton1;

	@FindBy(xpath = "//a[@id='btnPlaceBid']")
	protected WebElement placebidhybrid;

	@FindBy(xpath = "//a[@title='Manage System Parameters']")
	protected WebElement SystemParameters;
	
	@FindBy(xpath = "//a[@title='Auction Lots']")
	protected WebElement Lottab;

	@FindBy(xpath = "//td[@class='row0-alf5 alf5-col31 sticky li-actions']//a[@title='Delete']")
	protected WebElement deletelots;

	@FindBy(xpath = "//table//tr[1]//td//a[@title='Preview']")
	protected WebElement lotpreview;

	@FindBy(xpath = "//input[@id='lip130']")
	protected WebElement closingdate;

	@FindBy(xpath = "//ul[@id='ui-id-1']")
	protected WebElement Biddingnowandupcoming;

	@FindBy(xpath = "//div[@id='ui-id-26']")
	protected WebElement Timedonly;

	@FindBy(xpath = "//div[@id='ui-id-42']")
	protected WebElement selectauctioner;
	
	@FindBy(xpath = "//input[@id='lstrf04']")
	protected WebElement savecustomtemplate;
	
	@FindBy(xpath = "//a[contains(text(),'Auctioneers')]")
	protected WebElement Auctioneers;
	
	@FindBy(xpath = "//a[@id='section-items1'] | //a[@id='unassignedUserSection']")
	protected WebElement expandBidderTab;
	
	@FindBy(xpath = "//span[@id='ilf18_ctl'] | //span[@id='stilf18_ctl']")
	protected WebElement username;
	
	@FindBy(xpath = "//span[contains(text(),\"Buyer's Premium rule:\")] | //input[@id='bp5']")
	protected WebElement addnewbprule;
	
	@FindBy(xpath = "//a[contains(text(),'Admin options')]")
    protected WebElement AdminOptions;
	



	/**
	 * Initialize UserAbstractPage.
	 * 
	 * @param Driver
	 */
	public AbstractPage(WebDriver driver) {

		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}

}