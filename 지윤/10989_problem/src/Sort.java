import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		int count=0; //�Է¹��� ���� ����
		int []num; //�Է¹��� ���ڸ� �迭�� ���� 
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("");
		count= sc.nextInt();
		num=new int[count];
		
		for (int i = 0; i < count ; i++) {
			num[i]=sc.nextInt();
		}
		
		//�迭�� �����ϱ� ���� �޼ҵ� ����!
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
