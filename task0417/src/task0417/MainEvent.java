package task0417;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class User{
	String name;
	User(){}
	User(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return name;
	}
	//로그인 메서드 : 리스트의 이름과 일치하면 로그인
	public User login(ArrayList<User>users) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사용자 이름을 입력하세요");
		System.out.print("사용자 이름 : ");
		String inname = sc.next();
		
		User user = null;
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getName().equals(inname)){
				user = users.get(i);
				System.out.println(user);
			}
		}
		return user;
	}
}

class Event{
	String title;
	Date startdate;
	Date enddate;
	String detail;

	Event(){}
	Event(String title){
		this.title = title;
	}
	public Event(String title, Date startdate, Date enddate, String detail) {
		this.title = title;
		this.startdate = startdate;
		this.enddate = enddate;
		this.detail = detail;
	}
	public static Event e1;
	public static Event e2;
	public static Event e3;
	static {
		e1 = new Event("높은 곳에서 아이를 낳는 동물은?");
		e2 = new Event("정답은");
		e3 = new Event("하이에나");
	}
	public String getTitle() {
		return title;
	}
	public Date getStartdate() {
		return startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public String getDetail() {
		return detail;
	}
	public String toString() {
		return "\n이벤트 : "+title+" | 시작 : "+startdate+" | 종료 : "+enddate+" | 세부사항 : "+detail+"\n";
	}
	//이벤트 만들기 메서드
	public Event makeEvent(ArrayList<Event>events) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		String pattern = "yyyy-MM-dd hh:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		Date sdate = null;
		Date edate = null;
		System.out.println("이벤트 제목을 입력해주세요");
		System.out.print("제목 : ");
		String rsp5 = sc.next();
		System.out.println("이벤트 시작 시간을 입력해주세요. 형식:"+pattern);
		System.out.print("시작 :");
		while(sc.hasNextLine()) {
			try {
				sdate = df.parse(sc.nextLine());
				break;
			}catch(Exception e) {
				System.out.println("올바른 형식이 아닙니다");
			}
		}
		System.out.println("이벤트 종료 시간을 입력해주세요. 형식:"+pattern);
		System.out.print("종료 : ");
		while(sc.hasNextLine()) {
			try {
				edate = df.parse(sc.nextLine());
				break;
			}catch(Exception e) {
				System.out.println("올바른 형식이 아닙니다");
			}
		}
		System.out.println("이벤트 세부 내용을 입력해주세요");
		String rsp8 = sc.next();
		Event event = new Event(rsp5, sdate, edate, rsp8);
		events.add(event);
		System.out.println("SYSTEM : 이벤트 생성 완료");
		System.out.println(event);
		return event;
	}
	public Event updateEvent(Event event) { 
		System.out.println("이벤트 변경을 시작합니다");
		Scanner sc = new Scanner(System.in);
		String pattern = "yyyy-MM-dd hh:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		Date sdate = null;
		Date edate = null;
		System.out.println("변경할 이벤트 제목을 입력해주세요");
		System.out.print("제목 : ");
		String rsp5 = sc.nextLine();
		System.out.println("변경할 이벤트 시작 시간을 입력해주세요. 형식:"+pattern);
		System.out.print("시작 : ");
		while(sc.hasNextLine()) {
			try {
				sdate = df.parse(sc.nextLine());
				break;
			}catch(Exception e) {
				System.out.println("올바른 형식이 아닙니다");
			}
		}
		System.out.println("변경할 이벤트 종료 시간을 입력해주세요. 형식:"+pattern);
		System.out.print("종료 : ");
		while(sc.hasNextLine()) {
			try {
				edate = df.parse(sc.nextLine());
				break;
			}catch(Exception e) {
				System.out.println("올바른 형식이 아닙니다");
			}
		}
		System.out.println("변경할 이벤트 세부 내용을 입력해주세요");
		String rsp8 = sc.next();
		event = new Event (rsp5, sdate, edate, rsp8);
		return event;
	}
}
//파일 저장, 로드
class FileSaver{ 
	FileSaver(){}
	public void saveFile(String data, String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.println(data);
        }
	}
	public void loadFile(String fileName) throws IOException{
		StringBuilder sb = new StringBuilder();
	}
}

class MyCalendar{
	int year;
	int month;
	
	MyCalendar(){
	}
	//캘린더 조회 기능
	public void showCal() {
		
		Calendar day = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		String w = "일월화수목금토";
		System.out.println("조회할 달력의 년도를 입력하시오");
		int year = sc.nextInt();
		System.out.println("조회할 달력의 월을 입력하시오");
		int month = sc.nextInt();
		day.set(year, month-1, 1);
		int start = day.get(Calendar.DAY_OF_WEEK);
		System.out.printf("\t %d년 %d월 \n",
				 day.get(Calendar.YEAR), day.get(Calendar.MONTH)+1);
		for(int i=0;i<w.length();i++) {
			System.out.printf("%c"+"\t",w.charAt(i));
		}
		System.out.println();
		for(int i=0;i<start-1;i++) {
			System.out.println("\t");
		}
		for(int i=1;i<=day.getActualMaximum(Calendar.DATE);i++) {
			System.out.printf("%d\t",i);
			if(start%7==0) {
				System.out.println();
			}
			start++;
		}
		System.out.println();
		System.out.println();
	}
}

//구동클래스
public class MainEvent {
	static User User = new User();
	static Event Event = new Event();

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList <User> users = new ArrayList<>();
		ArrayList<Event> events = new ArrayList<>();
		User u1 = new User();
		u1.name = "hong";
		users.add(u1);
		User u2 = new User();
		u2.name = "kim";
		users.add(u2);
		System.out.println(users+":등록된 유저(이 문구는 사용자에게 보이지 않습니다)");
		
		Scanner sc = new Scanner(System.in);
		Thread.sleep(500);
		System.out.println("===============================");
		System.out.println("반갑습니다 GDJ 이벤트 캘린더를 실행합니다");
		System.out.println("===============================");
		Thread.sleep(500);
		User logined = null;
		User user = new User();
		Event event = new Event();
		MyCalendar mcal = new MyCalendar();
		events.add(Event.e1);
		events.add(Event.e2);
		events.add(Event.e3);

		while(true) {
			if(logined == null) {
				logined = User.login(users);
			}else {
				System.out.println(logined.getName()+"님 반갑습니다");
				Thread.sleep(500);
				break;
			}
		}
		boolean run = true;
		while(run) {
			System.out.println("========================MENU==========================");
			System.out.println("1.종료 2.달력조회 3.이벤트추가 4.이벤트조회 5.이벤트변경 6.이벤트삭제");
			int rsp = sc.nextInt();
			switch(rsp) {
				case 1 :
					System.out.println("정말 종료하시겠습니까? (1.예/2.아니오)");
					int rsp3 = sc.nextInt();
					switch(rsp3) {
					case 1 :
						System.out.println("다음에 또 방문해주세요");
						System.out.println("===서비스를 종료합니다===");
						run = false;
						break;
					case 2 :
						break;
					default : System.out.println("잘못된 키 조작입니다");
					}
					break;
				case 2 :
					System.out.println("===달력조회===");
					mcal.showCal();
					break;
				case 3 :
					System.out.println("===이벤트 생성===");
					event.makeEvent(events);
					break;
				case 4 :
					System.out.println("===이벤트 조회===");
					System.out.println("기록한 이벤트는 "+events.size()+"개 입니다");
					System.out.println(events);
					break;
				case 5 :
					System.out.println("===이벤트 변경===");
					System.out.println("SYSTEM : 변경할 이벤트를 선택하세요");
					int cnt5 = 0;
					for(int i=0;i<events.size();i++) {
					cnt5 = i;
					System.out.println((cnt5+1)+"번 이벤트 제목 : "+events.get(cnt5).getTitle());
					}
					int slc5 = sc.nextInt();
					if(cnt5+1==slc5) {
						System.out.println(events.get(cnt5));
						events.set(cnt5, event.updateEvent(events.get(cnt5)));
					}
					break;
				case 6 :
					System.out.println("===이벤트 삭제===");
					System.out.println("SYSTEM : 삭제할 이벤트를 선택하세요");
					int cnt6 = 0;
					for(int i=0;i<events.size();i++) {
						cnt6 = i;
						System.out.println((cnt6+1)+"번 이벤트 제목 : "+events.get(cnt6).getTitle());
					}
					int slc = sc.nextInt();
					if(cnt6+1==slc) {
						System.out.println("SYSTEM : "+events.get(cnt6).getTitle()+" : 정말 삭제하시겠습니까? (1.예/2.아니오)");
						System.out.println(events.get(cnt6));
						int slc2 = sc.nextInt();
						switch(slc2) {
							case 1 : 
								events.remove(cnt6);
								System.out.println("SYSTEM : 삭제되었습니다");
								break;
							case 2 :
								break;
							default : System.out.println("");
								}
					}else if(cnt6>slc || cnt6<slc) {
						System.out.println("SYSTEM : 잘못된 키 조작입니다");
					}
					break;
				default : System.out.println("SYSTEM : 입력오류");
			}
		}
	}
}
