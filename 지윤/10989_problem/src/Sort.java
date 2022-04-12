import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		int count=0; //입력받을 숫자 갯수
		int []num; //입력받을 숫자를 배열에 저장 
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("");
		count= sc.nextInt();
		num=new int[count];
		
		for (int i = 0; i < count ; i++) {
			num[i]=sc.nextInt();
		}
		
		//배열을 정렬하기 위한 메소드 생성!
		for (int i = 0; i<num.length;i++) {
			for(int j=i+1; j<num.length; j++) {
				if(num[i]>num[j]) {
					int temp = num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}
		for(int i=0;i<num.length;i++) {
			System.out.println(num[i]);
		}
	}

}
