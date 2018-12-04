package overriddenFeatures;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFeatureOverride {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumSetup/chromedriver_win32/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 
		// Open chrome
		driver.get("https://Syngenta:Syngenta1@synqa.test-syngentacp.acsitefactory.com/");
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/ul/li[3]/a")).click();
		WebElement ele = driver.findElement(By.id("edit-name"));
		ele.clear();
		ele.sendKeys("soniya.vijaywargi@syngenta.com");
		WebElement ele1 = driver.findElement(By.id("edit-pass"));
		ele1.clear();
		ele1.sendKeys("DanceSoniya@1234");
		WebElement wb = driver.findElement(By.id("edit-submit"));
		wb.click();
		driver.findElement(By.id("navbar-item--2")).click();
		driver.get("https://synqa.test-syngentacp.acsitefactory.com/admin/structure/features");
		driver.findElement(By.linkText("Syngenta")).click();
		try {
		WebElement web = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_banner/diff'][@style='display: inline;']"));
		String s1 = web.getText();
		String s2 = web.getAttribute("href");
		System.out.println("The status of "+s2+ " " +s1);
		}
		catch (Exception e) {
			System.out.println("Disabled");
		}
		try {
		WebElement web1 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_admin'][@style='display: inline;']"));
		String t1 = web1.getText();
		String t2 = web1.getAttribute("href");
		System.out.println("The status of "+t2+ " " +t1);
        }
        catch (Exception e) {
        	System.out.println("Status is Disabled");
        
        }
		try {
		WebElement w1 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_basic_page/diff'][@style='display: inline;']"));
		String b1 = w1.getText();
		String b2 = w1.getAttribute("href");
		System.out.println("The status of "+b2+ " " +b1);
		}
		catch (Exception e) {
			System.out.println("Status is Disabled");
		}
		try {
			WebElement w2 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_bookmarks'][@style='display: inline;']"));
			String c1 = w2.getText();
			String c2 = w2.getAttribute("href");
			System.out.println("The status of "+c2+ " " +c1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w3 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_breadcrumb'][@style='display: inline;']"));
			String d1 = w3.getText();
			String d2 = w3.getAttribute("href");
			System.out.println("The status of "+d2+ " " +d1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w4 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_calculator'][@style='display: inline;']"));
			String e1 = w4.getText();
			String e2 = w4.getAttribute("href");
			System.out.println("The status of "+e2+ " " +e1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w5 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_campaigns/diff'][@style='display: inline;']"));
			String f1 = w5.getText();
			String f2 = w5.getAttribute("href");
			System.out.println("The status of "+f2+ " " +f1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
	    try {
			WebElement w6 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_cip'][@style='display: inline;']"));
			String g1 = w6.getText();
			String g2 = w6.getAttribute("href");
			System.out.println("The status of "+g2+ " " +g1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w7 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_contact/diff'][@style='display: inline;']"));
			String h1 = w7.getText();
			String h2 = w7.getAttribute("href");
			System.out.println("The status of "+h2+ " " +h1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w8 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_contact_finder'][@style='display: inline;']"));
			String i1 = w8.getText();
			String i2 = w8.getAttribute("href");
			System.out.println("The status of "+i2+ " " +i1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w9 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_core/diff'][@style='display: inline;']"));
			String j1 = w9.getText();
			String j2 = w9.getAttribute("href");
			System.out.println("The status of "+j2+ " " +j1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w10 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_country_content'][@style='display: inline;']"));
			String k1 = w10.getText();
			String k2 = w10.getAttribute("href");
			System.out.println("The status of "+k2+ " " +k1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w11 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_country_core'][@style='display: inline;']"));
			String l1 = w11.getText();
			String l2 = w11.getAttribute("href");
			System.out.println("The status of "+l2+ " " +l1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w12 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_customer/diff'][@style='display: inline;']"));
			String m1 = w12.getText();
			String m2 = w12.getAttribute("href");
			System.out.println("The status of "+m2+ " " +m1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w13 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_distributor'][@style='display: inline;']"));
			String n1 = w13.getText();
			String n2 = w13.getAttribute("href");
			System.out.println("The status of "+n2+ " " +n1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w14 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_distributor_flower'][@style='display: inline;']"));
			String o1 = w14.getText();
			String o2 = w14.getAttribute("href");
			System.out.println("The status of "+o2+ " " +o1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w15 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_distributor_yandex_map'][@style='display: inline;']"));
			String p1 = w15.getText();
			String p2 = w15.getAttribute("href");
			System.out.println("The status of "+p2+ " " +p1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w16 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_editorial/diff'][@style='display: inline;']"));
			String q1 = w16.getText();
			String q2 = w16.getAttribute("href");
			System.out.println("The status of "+q2+ " " +q1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w17 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_embed_tokens'][@style='display: inline;']"));
			String r1 = w17.getText();
			String r2 = w17.getAttribute("href");
			System.out.println("The status of "+r2+ " " +r1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w18 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_error_handling'][@style='display: inline;']"));
			String s1 = w18.getText();
			String s2 = w18.getAttribute("href");
			System.out.println("The status of "+s2+ " " +s1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w19 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_event_management'][@style='display: inline;']"));
			String t1 = w19.getText();
			String t2 = w19.getAttribute("href");
			System.out.println("The status of "+t2+ " " +t1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w20 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_exact_target_newsletter/diff'][@style='display: inline;']"));
			String u1 = w20.getText();
			String u2 = w20.getAttribute("href");
			System.out.println("The status of "+u2+ " " +u1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w21 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_faq/diff'][@style='display: inline;']"));
			String v1 = w21.getText();
			String v2 = w21.getAttribute("href");
			System.out.println("The status of "+v2+ " " +v1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w22 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_forms'][@style='display: inline;']"));
			String w1 = w22.getText();
			String w2 = w22.getAttribute("href");
			System.out.println("The status of "+w2+ " " +w1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w23 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_geo'][@style='display: inline;']"));
			String x1 = w23.getText();
			String x2 = w23.getAttribute("href");
			System.out.println("The status of "+x2+ " " +x1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w24 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_global_footer'][@style='display: inline;']"));
			String y1 = w24.getText();
			String y2 = w24.getAttribute("href");
			System.out.println("The status of "+y2+ " " +y1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w25 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_health_certificate'][@style='display: inline;']"));
			String z1 = w25.getText();
			String z2 = w25.getAttribute("href");
			System.out.println("The status of "+z2+ " " +z1);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w26 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_i18n/diff'][@style='display: inline;']"));
			String a11 = w26.getText();
			String a22 = w26.getAttribute("href");
			System.out.println("The status of "+a22+ " " +a11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w27 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_imports'][@style='display: inline;']"));
			String b11 = w27.getText();
			String b22 = w27.getAttribute("href");
			System.out.println("The status of "+b22+ " " +b11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w28 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_landing_page/diff'][@style='display: inline;']"));
			String c11 = w28.getText();
			String c22 = w28.getAttribute("href");
			System.out.println("The status of "+c22+ " " +c11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w29 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_lms/diff'][@style='display: inline;']"));
			String d11 = w29.getText();
			String d22 = w29.getAttribute("href");
			System.out.println("The status of "+d22+ " " +d11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w29 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_lms/diff'][@style='display: inline;']"));
			String d11 = w29.getText();
			String d22 = w29.getAttribute("href");
			System.out.println("The status of "+d22+ " " +d11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w30 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_lms_seedcare'][@style='display: inline;']"));
			String e11 = w30.getText();
			String e22 = w30.getAttribute("href");
			System.out.println("The status of "+e22+ " " +e11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w31 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_locale'][@style='display: inline;']"));
			String f11 = w31.getText();
			String f22 = w31.getAttribute("href");
			System.out.println("The status of "+f22+ " " +f11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w32 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_media/diff'][@style='display: inline;']"));
			String g11 = w32.getText();
			String g22 = w32.getAttribute("href");
			System.out.println("The status of "+g22+ " " +g11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w33 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_media_gallery_events/diff'][@style='display: inline;']"));
			String h11 = w33.getText();
			String h22 = w33.getAttribute("href");
			System.out.println("The status of "+h22+ " " +h11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w34 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_mega_footer'][@style='display: inline;']"));
			String i11 = w34.getText();
			String i22 = w34.getAttribute("href");
			System.out.println("The status of "+i22+ " " +i11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w35 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_mega_menu'][@style='display: inline;']"));
			String j11 = w35.getText();
			String j22 = w35.getAttribute("href");
			System.out.println("The status of "+j22+ " " +j11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w36 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_news/diff'][@style='display: inline;']"));
			String k11 = w36.getText();
			String k22 = w36.getAttribute("href");
			System.out.println("The status of "+k22+ " " +k11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w37 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_newsletter'][@style='display: inline;']"));
			String l11 = w37.getText();
			String l22 = w37.getAttribute("href");
			System.out.println("The status of "+l22+ " " +l11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w38 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_panels/diff'][@style='display: inline;']"));
			String m11 = w38.getText();
			String m22 = w38.getAttribute("href");
			System.out.println("The status of "+m22+ " " +m11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w39 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_performance'][@style='display: inline;']"));
			String n11 = w39.getText();
			String n22 = w39.getAttribute("href");
			System.out.println("The status of "+n22+ " " +n11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w40 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_polls/diff'][@style='display: inline;']"));
			String o11 = w40.getText();
			String o22 = w40.getAttribute("href");
			System.out.println("The status of "+o22+ " " +o11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w41 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_price_list'][@style='display: inline;']"));
			String p11 = w41.getText();
			String p22 = w41.getAttribute("href");
			System.out.println("The status of "+p22+ " " +p11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w42 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_product_cp/diff'][@style='display: inline;']"));
			String q11 = w42.getText();
			String q22 = w42.getAttribute("href");
			System.out.println("The status of "+q22+ " " +q11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w43 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_primary_menu'][@style='display: inline;']"));
			String r11 = w43.getText();
			String r22 = w43.getAttribute("href");
			System.out.println("The status of "+r22+ " " +r11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w44 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_product_flower'][@style='display: inline;']"));
			String s11 = w44.getText();
			String s22 = w44.getAttribute("href");
			System.out.println("The status of "+s22+ " " +s11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w45 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_product_seed/diff'][@style='display: inline;']"));
			String t11 = w45.getText();
			String t22 = w45.getAttribute("href");
			System.out.println("The status of "+t22+ " " +t11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w46 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_product_target/diff'][@style='display: inline;']"));
			String u11 = w46.getText();
			String u22 = w46.getAttribute("href");
			System.out.println("The status of "+u22+ " " +u11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w47 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_products/diff'][@style='display: inline;']"));
			String v11 = w47.getText();
			String v22 = w47.getAttribute("href");
			System.out.println("The status of "+v22+ " " +v11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w48 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_regions/diff'][@style='display: inline;']"));
			String w11 = w48.getText();
			String w22 = w48.getAttribute("href");
			System.out.println("The status of "+w22+ " " +w11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w49 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_reward_points'][@style='display: inline;']"));
			String x11 = w49.getText();
			String x22 = w49.getAttribute("href");
			System.out.println("The status of "+x22+ " " +x11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w50 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_royalty_report'][@style='display: inline;']"));
			String y11 = w50.getText();
			String y22 = w50.getAttribute("href");
			System.out.println("The status of "+y22+ " " +y11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w51 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_sales_rep/diff'][@style='display: inline;']"));
			String z11 = w51.getText();
			String z22 = w51.getAttribute("href");
			System.out.println("The status of "+z22+ " " +z11);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w52 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_salesforce'][@style='display: inline;']"));
			String a33 = w52.getText();
			String a44 = w52.getAttribute("href");
			System.out.println("The status of "+a44+ " " +a33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w53 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_search/diff'][@style='display: inline;']"));
			String b33 = w53.getText();
			String b44 = w53.getAttribute("href");
			System.out.println("The status of "+b44+ " " +b33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w54 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_secondary_menu'][@style='display: inline;']"));
			String c33 = w54.getText();
			String c44 = w54.getAttribute("href");
			System.out.println("The status of "+c44+ " " +c33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w55 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_security'][@style='display: inline;']"));
			String d33 = w55.getText();
			String d44 = w55.getAttribute("href");
			System.out.println("The status of "+d44+ " " +d33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w56 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_seo/diff'][@style='display: inline;']"));
			String e33 = w56.getText();
			String e44 = w56.getAttribute("href");
			System.out.println("The status of "+e44+ " " +e33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w57 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_service/diff'][@style='display: inline;']"));
			String f33 = w57.getText();
			String f44 = w57.getAttribute("href");
			System.out.println("The status of "+f44+ " " +f33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w58 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_service_agriclime/diff'][@style='display: inline;']"));
			String g33 = w58.getText();
			String g44 = w58.getAttribute("href");
			System.out.println("The status of "+g44+ " " +g33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w59 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_service_de/diff'][@style='display: inline;']"));
			String h33 = w59.getText();
			String h44 = w59.getAttribute("href");
			System.out.println("The status of "+h44+ " " +h33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w60 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_service_de_pm_model/diff'][@style='display: inline;']"));
			String i33 = w60.getText();
			String i44 = w60.getAttribute("href");
			System.out.println("The status of "+i44+ " " +i33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w61 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_service_hyvido/diff'][@style='display: inline;']"));
			String j33 = w61.getText();
			String j44 = w61.getAttribute("href");
			System.out.println("The status of "+j44+ " " +j33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w62 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_service_seedtreatment'][@style='display: inline;']"));
			String k33 = w62.getText();
			String k44 = w62.getAttribute("href");
			System.out.println("The status of "+k44+ " " +k33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w63 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_service_sunflower'][@style='display: inline;']"));
			String l33 = w63.getText();
			String l44 = w63.getAttribute("href");
			System.out.println("The status of "+l44+ " " +l33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w64 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_service_weather/diff'][@style='display: inline;']"));
			String m33 = w64.getText();
			String m44 = w64.getAttribute("href");
			System.out.println("The status of "+m44+ " " +m33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w65 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_service_weed_id/diff'][@style='display: inline;']"));
			String n33 = w65.getText();
			String n44 = w65.getAttribute("href");
			System.out.println("The status of "+n44+ " " +n33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w66 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_sidebar_right'][@style='display: inline;']"));
			String o33 = w66.getText();
			String o44 = w66.getAttribute("href");
			System.out.println("The status of "+o44+ " " +o33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w67 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_site_header_footer'][@style='display: inline;']"));
			String p33 = w67.getText();
			String p44 = w67.getAttribute("href");
			System.out.println("The status of "+p44+ " " +p33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			}
		try {
			WebElement w68 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_sitemap/diff'][@style='display: inline;']"));
			String q33 = w68.getText();
			String q44 = w68.getAttribute("href");
			System.out.println("The status of "+q44+ " " +q33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w69 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_social/diff'][@style='display: inline;']"));
			String r33 = w69.getText();
			String r44 = w69.getAttribute("href");
			System.out.println("The status of "+r44+ " " +r33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w70 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_sticky_menu'][@style='display: inline;']"));
			String s33 = w70.getText();
			String s44 = w70.getAttribute("href");
			System.out.println("The status of "+s44+ " " +s33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w71 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_taxonomy'][@style='display: inline;']"));
			String t33 = w71.getText();
			String t44 = w71.getAttribute("href");
			System.out.println("The status of "+t44+ " " +t33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w72 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_technical_library_flower'][@style='display: inline;']"));
			String u33 = w72.getText();
			String u44 = w72.getAttribute("href");
			System.out.println("The status of "+u44+ " " +u33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w73 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_user'][@style='display: inline;']"));
			String v33 = w73.getText();
			String v44 = w73.getAttribute("href");
			System.out.println("The status of "+v44+ " " +v33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w74 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_user_import'][@style='display: inline;']"));
			String w33 = w74.getText();
			String w44 = w74.getAttribute("href");
			System.out.println("The status of "+w44+ " " +w33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		try {
			WebElement w75 = driver.findElement(By.xpath("//a[@href='/admin/structure/features/syn_web_services'][@style='display: inline;']"));
			String y33 = w75.getText();
			String y44 = w75.getAttribute("href");
			System.out.println("The status of "+y44+ " " +y33);
			}
			catch (Exception e) {
				System.out.println("Status is Disabled");
			} 
		
		driver.close();
		}
	
	
}
