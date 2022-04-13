import java.util.Scanner;

public class Sort {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		
		int arr[] = new int[N]; //�Է� �迭 arr
		int counting[] = new int[10001]; //������ 10000���� �۰ų� ���� �ڿ��� ��� ������ 
										//0�� ���ܵǰ� 1 ���� 10000 (���� Ƚ���� ���� counting�迭)
		int result[] = new int[N]; //��� result �迭

		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();//N �Է¹���
		}
		// Counting Sort(�������� ����) 
		for(int i = 0; i < arr.length; i++) {
			// array �� value ���� index �� �ϴ� counting �迭 �� 1 ���� 
			counting[arr[i]]++;			
		}
		for(int i = 1; i < counting.length; i++) {
			 //���� �� ���ֱ� 
			counting[i] += counting[i - 1]; //�迭�̴ϱ� -1
		}
		for(int i = arr.length - 1; i >= 0; i--) {
			 //  i ���� ���Ҹ� �ε����� �ϴ� counting �迭�� 1 ���ҽ�Ų �� 
			 //  counting �迭�� ���� �ε����� �Ͽ� result�� value ���� �����Ѵ�.
			int value = arr[i];
			counting[value]--;
			result[counting[value]] = value;
		}
		System.out.println();
		// ���ĵ� �迭
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]+"\n");
		}
	}
}
