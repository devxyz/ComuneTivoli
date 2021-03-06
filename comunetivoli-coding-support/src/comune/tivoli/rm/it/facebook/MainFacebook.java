package comune.tivoli.rm.it.facebook;

import facebook4j.*;
import facebook4j.auth.AccessToken;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 * Created by stefano on 11/07/16.
 */
public class MainFacebook {
    public static String toDDMMYYY(Date d) {
        if (d == null) return "--/--/---";
        // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date (month/day/year)
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        // Using DateFormat format method we can create a string
        // representation of a date with the defined format.
        return df.format(d);
    }

    private static String parseName(String s, StringBuilder sb) {
        sb.setLength(0);

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (c) {
                case '%':
                    try {
                        sb.append((char) Integer.parseInt(s.substring(i + 1, i + 3), 16));
                        i += 2;
                    } catch (NumberFormatException var6) {
                        throw new IllegalArgumentException();
                    } catch (StringIndexOutOfBoundsException var7) {
                        String rest = s.substring(i);
                        sb.append(rest);
                        if (rest.length() == 2) {
                            ++i;
                        }
                    }
                    break;
                case '+':
                    sb.append(' ');
                    break;
                default:
                    sb.append(c);
            }
        }

        return sb.toString();
    }

    public static Hashtable<String, String[]> parseQueryString(String s) {
        String[] valArray = null;
        if (s == null) {
            throw new IllegalArgumentException();
        } else {
            Hashtable ht = new Hashtable();
            StringBuilder sb = new StringBuilder();

            String key;
            for (StringTokenizer st = new StringTokenizer(s, "&"); st.hasMoreTokens(); ht.put(key, valArray)) {
                String pair = st.nextToken();
                int pos = pair.indexOf(61);
                if (pos == -1) {
                    throw new IllegalArgumentException();
                }

                key = parseName(pair.substring(0, pos), sb);
                String val = parseName(pair.substring(pos + 1, pair.length()), sb);
                if (!ht.containsKey(key)) {
                    valArray = new String[]{val};
                } else {
                    String[] oldVals = (String[]) ht.get(key);
                    valArray = new String[oldVals.length + 1];

                    for (int i = 0; i < oldVals.length; ++i) {
                        valArray[i] = oldVals[i];
                    }

                    valArray[oldVals.length] = val;
                }
            }

            return ht;
        }
    }


    public static void main(String[] args) throws FacebookException {

        //HtmlUnitDriver driver = new HtmlUnitDriver();
        //FirefoxDriver driver = new FirefoxDriver(profile);

        Facebook facebook = new FacebookFactory().getInstance();

        facebook.setOAuthAppId("543019475885107", "d872b23ffa043528f76676b0eb38e265");
        facebook.setOAuthPermissions("user_friends,user_about_me,public_profile,user_posts,user_photos");
        final AccessToken s = facebook.getOAuthAppAccessToken();
        System.out.println(s);


        Reading r = new Reading().limit(10);
        r = r.order(Ordering.CHRONOLOGICAL);


        final String giuseppeproiettisindacoID = "giuseppeproiettisindaco";
        final User sindaco = facebook.users().getUser(giuseppeproiettisindacoID);
        final ResponseList<Post> pp = facebook.getFeed(giuseppeproiettisindacoID, r);
        //facebook.getsh



        System.out.println(sindaco);
        System.out.println("===========================");
        for (Post a : pp) {
            //if (a.getMessage()==null)continue;
            //System.out.println(a);
            System.out.println(toDDMMYYY(a.getCreatedTime()) + " " + a.getId());
            System.out.println("Actions: " + a.getActions());
            System.out.println("Caption: " + a.getCaption());
            System.out.println("Name: " + a.getName());
            System.out.println("Status Type: " + a.getStatusType());
            System.out.println("Story: " + a.getStory());
            System.out.println("Type: " + a.getType());
            System.out.println("From: " + a.getFrom());
            System.out.println("ParentId: " + a.getParentId());
            System.out.println("Link: " + a.getLink());
            System.out.println("Picture: " + a.getFullPicture());
            System.out.println("Icon: " + a.getIcon());
            System.out.println("Picture: " + a.getPicture());
            System.out.println("Tags: " + a.getMessageTags());
            System.out.println("Source: " + a.getSource());

            System.out.println("Description: " + a.getDescription());
            System.out.println("Message: " + a.getMessage());
            System.out.println("================================================================================================================================");
        }


//        final String code1 = doWeb(driver, facebook);
        //final String code1 = "AQCo64EwER2Go_gjmlW_LhzIUrT4ngeavyEZjbYiLKwXH9jDHacUT95_R8dXrG3wuz7z26gYD4cJ6iZpLCSFSeDlw_h-SyPVL1GeiE4odhYW-SR6BkWctaHe-qrCaxBypyg9RKFd8sqLXBjHezBETWcW1__JYa8s8ZD52epAWukir176Qu4c_6K5ZVbhdNQOsLiRICRGaMUSDjPL9z_4D4AMfLr9bLUcNEMTEZPM3sRvigS47D01E_1iPkaNMqqnZMfd-UwNZ8QWJkhxAotqiRyVvn270j1VQEOV7DnjY1SG_WvEA7qfT1oqB6vuAw3lYA8";

        //doFacebook(facebook, code1);

        //      driver.close();

    }

    private static String doWeb(FirefoxDriver driver, Facebook facebook) {
        final String oAuthAuthorizationURL = facebook.getOAuthAuthorizationURL("http://localhost");
        System.out.println(oAuthAuthorizationURL);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.get(oAuthAuthorizationURL);
        final WebElement email = driver.findElementById("email");
        email.sendKeys("stefano.millozzi@gmail.com");

        final WebElement password = driver.findElementById("pass");
        password.sendKeys("Stefano123");

        final WebElement loginbutton = driver.findElementById("loginbutton");
        loginbutton.click();

        final String currentUrl = driver.getCurrentUrl();
        final Hashtable<String, String[]> code = parseQueryString(currentUrl.split("[?]")[1]);
        System.out.println();
        System.out.println(currentUrl);
        System.out.println();
        final String code1 = code.get("code")[0].split("#")[0];

        System.out.println(code1);

        return code1;
    }

    private static void doFacebook(Facebook facebook, String code1) throws FacebookException {
        final AccessToken accessToken = facebook.getOAuthAccessToken(code1);

        System.out.println(accessToken);

        final List<User> user = facebook.getUsers("me");


        final ResponseList<Friend> friends = facebook.getFriends();
        System.out.println(friends);
    }
}
