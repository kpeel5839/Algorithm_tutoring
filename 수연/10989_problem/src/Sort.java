import java.util.Scanner;

public class Sort {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		
		int arr[] = new int[N]; //입력 배열 arr
		int counting[] = new int[10001]; //범위가 10000보다 작거나 같은 자연수 라고 했으니 
										//0은 제외되고 1 부터 10000 (등장 횟수를 세는 counting배열)
		int result[] = new int[N]; //결과 result 배열

		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();//N 입력받음
		}
		// Counting Sort(오름차순 정렬) 
		for(int i = 0; i < arr.length; i++) {
			// array 의 value 값을 index 로 하는 counting 배열 값 1 증가 
			counting[arr[i]]++;			
		}
		for(int i = 1; i < counting.length; i++) {
			 //누적 합 해주기 
			counting[i] += counting[i - 1]; //배열이니까 -1
		}
		for(int i = arr.length - 1; i >= 0; i--) {
			 //  i 번쨰 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤 
			 //  counting 배열의 값을 인덱스로 하여 result에 value 값을 저장한다.
			int value = arr[i];
			counting[value]--;
			result[counting[value]] = value;
		}
		System.out.println();
		// 정렬된 배열
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]+"\n");
		}
	}
}
