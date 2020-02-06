package daum;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import domain.MovieDTO;
import persistence.MovieDAO;

public class OneMovie {                        
		public static void main(String[] args) throws IOException {
		
		String base = "https://movie.daum.net/moviedb/grade?movieId=134091&type=netizen&page=";
		int page = 1; // ������ ��������(1page = ��� 10��)
		String url =  base + page; 
		
		int score =0, regdate = 0, count=0;
		String title = "", writer, content, basedate, subdate = "";
		
		int total = 0; // ������ ��� ���ϴ� ����
		Double scoreAvg = 0.0; // ��� ����
		
		MovieDAO mDao = new MovieDAO();
		
		// �������� ���鼭 ����� ����!
		while(true) {
			// 1�������� ���� 10�� ����	
			Document doc = Jsoup.connect(url).get();
			Elements reply = doc.select("ul.list_netizen div.review_info");
			
						
			if(reply.isEmpty()) {
				break;
			}
			
				// ���� 1�� ����
				for (Element one : reply) { 
					count++;
					Elements movieName = doc.select("h2.tit_rel");
					title = movieName.text();
					writer = one.select("em.link_profile").text();
					score = Integer.parseInt(one.select("em.emph_grade").text());
					content = one.select("p.desc_review").text();
					
					basedate = one.select("span.info_append").text();
					subdate = basedate.substring(0,10);
					regdate = Integer.parseInt(subdate.replace(".", ""));
					
					// ���� ������ ���
					total += score; //total = total+ score;
					
					MovieDTO mDto = new MovieDTO(title, content, writer, score, "daum", regdate);
					
					// DB�� ����!
					mDao.addMovie(mDto);
					System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�"+count+"�� �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
					System.out.println("��ȭ :" + title);
					System.out.println("���� :" + score);
					System.out.println("�ۼ��� :" + writer);
					System.out.println("���� : "+ content);
					System.out.println("�ۼ����� :" + regdate);
					
				}// for ��
				page = page +1;
				url= base + page;
			}// while ��
			// ��� ���� ���
			scoreAvg = (double)total / count;
			// �Ҽ��� ù��° �ڸ����� ���(����)
			double result = Math.floor(scoreAvg);
	
		
			// ���� �� �м���� ���
			System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ� end �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
			System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
			System.out.println("�ƢƢƢ� "+ title +"Daum ��ȭ ���� ���� ��� ");
			System.out.println("�ƢƢƢ� "+ (page-1) + "����������");
			System.out.println("�ƢƢƢ� "+ count +"���� ������ ���� �Ϸ�");
			System.out.println("�ƢƢƢ� ��������� " + result +"�� :)");
			System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		
	} //����

		
}

