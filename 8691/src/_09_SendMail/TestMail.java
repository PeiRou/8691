package _09_SendMail;



import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;


public class TestMail {
 public void sendmail(String email, HttpServletRequest request) {
  String host = "smtp.gmail.com";
  int port = 587;
  final String username = "eeit83team05@gmail.com";
  final String password = "P3n154n41";//your password

  Properties props = new Properties();
  props.put("mail.smtp.host", host);
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.port", port);
  Session session = Session.getInstance(props, new Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username, password);
   }
  });
  
  

  try {
	  	


   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress("eeit83team05@gmail.com"));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
   message.setSubject("巴豆揪么(8691)系統註冊審核回覆");
   message.setSentDate(new java.util.Date()); 
	  MimeBodyPart textPart = new MimeBodyPart();
	   StringBuffer html = new StringBuffer();
	   html.append("Dear Levin,<br><br>"); 
	   html.append("此為 系統通知~<br>"); 
	   html.append("恭喜   先生/小姐  成為  店家會員 ，已完成系統註冊!<br>"); 
	   html.append("欲要登入系統~ 請點選連結"); 
	   String pathurl = "http://localhost:8080"+request.getContextPath()+"/_02_Login/Login.jsp";
	   String url = "<a href='"+pathurl+"'>按我回登入</a><br>";
	   html.append(url);
	   
	   html.append("若有需更新店家圖片Logo及介紹資料，請回傳訊息於8691管理團隊(EEIT83第五小組)!!"); 
	   html.append("我們將盡快更新  您的店家Logo及介紹資料正式上線後，將可更新您的菜單與商品!!!<br>"); 
	   html.append("EEIT83第五小組  敬上");
	
	   textPart.setContent(html.toString(), "text/html; charset=UTF-8");
	  
   
   
//   message.setText("Dear Levin, \n\n 測試 測試 測試 測試 測試 測試 email !  " +html);
   
//   String pathurl = HttpServletRequest.getContextPath()+"/index.jsp";
//
//   String url = "<a href='"+pathurl+"'>按我回首頁</a>";
//   String subject = "【查詢密碼通知】這是來自Travel To Taiwan系統通知信，請勿直接回覆此信";
//	String content = "Dear " + memberVO.getName_En() + "\n\n您的臨時密碼改為：" + randomPassword
//			+ "\n\n請於30分鐘內以此密碼登入，並至會員中心修改您的密碼。"
//			+ "\n\n\nTravel To Taiwan祝您旅遊愉快\n\n\n\n\n\t\t\t\t\t\tTravel To Taiwan  管理團隊  敬上"
//			+ "\n\n\n\n\n\n**********此為系統自動發送之信件，請勿直接回覆！**********";
   
	   //文字部分
	  
   Multipart email1 = new MimeMultipart();
   email1.addBodyPart(textPart);
   message.setContent(email1);
   
   
   Transport transport = session.getTransport("smtp");
   transport.connect(host, port, username, password);

   Transport.send(message);

   System.out.println("寄送email結束.");
   

  } catch (MessagingException e) {
   throw new RuntimeException(e);
  }
  
 }

private void sendTestmail(String string) {
	// TODO Auto-generated method stub
	
}

public static void main(String[] args){
	  TestMail mail= new TestMail();
		//mail.sendmail("w1225hg@hotmail.com");
System.out.println("結束~");	
}
}