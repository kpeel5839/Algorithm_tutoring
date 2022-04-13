import java.util.*;

// ���� ���� ���� ũ�ų� ���� ���� ���� , �� ������ ���Ҹ� ��� ���ذ����� ��� , �� ������ partition �� ������ linear select �˰���
public class Hello {
    public static int linearSelect(int[] arr , int p , int r , int find){

        // ����� 5 ������ ������ select �� �̿��ؼ� ���� ã���ش�. , p == r �� ������ ó�������� �ʴ´� , ¥�� select ���� ���� ����
        if(r - p < 5) return select(arr , p , r , find);

        // size �� ����
        int size = r - p + 1;

        // ������ �� ���� �ø��� �������ش�(�迭�� 5���� ���� �� ��� �ݺ��ؾ��ϴ��� ����)
        int loopCount = (int)Math.ceil((double)size / 5d);

        // �� 5�� ������ �迭���� �߾� ������ ������ tmp �迭
        int[] tmp = new int[loopCount];

        // ���� �� 5���� �迭���� �߾Ӱ��� ���� for ���� ����
        for(int i = 0; i < loopCount; i++){

            // 5�� ¥�� �迭�� ������ġ
            int pValue = p + 5 * i;

            // 5�� ¥�� �迭�� ������ ��ġ
            int rValue = pValue + 4;

            // ���� �����Ͽ��� �� , rValue �� Ư���� �ൿ�� �������־�� �Ѵ�.
            if(i == loopCount - 1){
                // ���� �������� ������ rValue ���ٰ� �׳� ������ �ε��� �־��ָ� �ȴ�.
                rValue = r;
            }

            // 5�� ¥���� �迭���� ��� ���� �̾Ƴ��� ���� ���� , ũ�Ⱑ 5�� ��쿡�� find == 3 �� ��� �Ѵ�.
            int findNumber = (rValue - pValue) / 2 + 1;

            // �� linearSelect �� ȣ���ϸ鼭 , �߾Ӱ����� ���� , Select �� �ٷ� ȣ���ص� ������ linearSelect ȣ���ص� , �ٷ� Select �� ȣ���ϱ� ������ , �������� ���� linearSelect �� ȣ��
            tmp[i] = linearSelect(arr , pValue , rValue , findNumber);
        }

        // �߾Ӱ��鿡�� �߾� ���� ���ϱ� ���ؼ� ,linearSelect �� ���ȣ�� �ϰ� �ȴ� (�̰� ���� ��� ���� ���ϱ� ���ؼ� (tmp.length - 1) / 2 + 1 �� ã�´ٰ� ���)
        int pivotValue = linearSelect(tmp , 0 , tmp.length - 1 , (tmp.length - 1) / 2 + 1);

        // ã�� ���� index �� ���ϰ� partition ���ٰ� �� index�� �Ѱܼ� �ش� pivotValue�� ���ؿ��ҷ� ����
        int q = partition(arr , p , r , findIndex(arr , pivotValue , p , r));

        System.out.println("q : " + q);
        // ���� ���Ұ� ���°�� ū ������ Ȯ��
        int k = q - p + 1;

        // Select ������ ����
        if(find < k) return linearSelect(arr , p , q - 1 , find);
        else if(find == k) return arr[q];
        else return linearSelect(arr , q + 1 , r , find - k);
    }

    // pivot value ���� �ε����� ã���ش� , linear select �� ȣ���� ���� ȣ�� ���Ѽ� Ž�� Ƚ���� �ٿ��ش�.
    public static int findIndex(int arr[] , int value , int p , int r){
        // value �� index �� ������ res
        int res = 0;

        // value �� index �� ã�� ���� , ����� ������ �ϱ� ���ؼ� , break; �� �̿�����
        for(int i = p; i <= r; i++){
            if(value == arr[i]) {
                res = i;
                break;
            } // ã�� index�� ������
        }

        // ã�� index ��ȯ
        return res;
    }

    // p = ó�� , r = ������ , i = ã�� ��
    public static int select(int[] arr , int p , int r , int i){
        // ��� Ž���� ���ؼ� find ������ �������鼭 �����߱⿡ , p == r �� ��� ã�� ���� (�ε��� ������ �����ֱ� ���ؼ��� �ش� ������ ����Ͽ��� ��)
        if(p >= r) return arr[p];

        // partition �� ���ؼ� ������ ���� �ֵ� , �������� ū �ֵ�� �з��ϰ� �ȴ�.
        int q = partition(arr , p , r , r);

        // ���� ���Ұ� ���� p ~ r ���� ���°�� ū�������� �����Ѵ�.
        int k = q - p + 1;

        // k �� �� ū ���� , �� i �� �� ���� ���� q �� ���ʿ� �ִٶ�� ���̴�. �׷��� ������ , ������ Ž�����ش�.
        if(k > i) return select(arr , p , q - 1 , i);

        // k == i ��� ���� ���ؿ��Ұ� ã�� ����� ���̴� , �׷��� ������ q�� ��ȯ�Ѵ� , k �� ��ȯ���� �ʴ� ������ k �� �ε���ó�� ǥ������ �ʾұ� �����̴�. ex) 0��° , 1��° ...
        else if(k == i) return arr[q];

        // ���� ��Ȳ�� �� �ƴ϶�� k���� i �� �� ū ���ۿ� �������� ���� , �׷��� ������ ������ �κ��� ��������� ȣ���Ѵ�.
        else return select(arr , q + 1 , r , i - k);

        /*
        return �� �� ���� ������ ���ܿ��� p == r �� �� ��� Ȥ�� k == i �� ��쿡 ���� return �ϰ� �Ǹ� ,
        ���������� ���� �������־�� �ϱ� �����̴� , �� �ش� ���� ã�� ���ؼ� ���ȣ���� �����Ͽ��� , �� ���ȣ����� ������� ��ȯ�޴´�.
        �׸��� ����ؼ� ������ ������ ȣ���� �ֵ鿡�� �ѱ�� ���� , �ᱹ ó���� ȣ���� �ֻ��� ȣ�⿡�� ���� ���޵� ���̴�.
         */
    }

    // p = ó�� , r = ������
    public static int partition(int[] arr , int p , int r , int pivot){

        // linear select �� ���� ã�� ������ ���ؿ��Ҹ� �� �������� ��ġ��Ŵ
        swap(arr , pivot , r);

        // ���ؿ��� ����
        int x = arr[r];
        int i = p - 1;

        for(int j = p; j < r; j++){
            if(arr[j] <= x) swap(arr , ++i , j); // ������ ��ġ�� ��ȯ
        }

        // ������ ������ ��ġ�� ���ؿ��Ҹ� swap
        swap(arr , ++i , r);

        // ���� ������ �ε����� ��ȯ
        return i;
    }

    // �׳� �������� swap
    public static void swap(int[] arr , int a , int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // �迭 ũ�� �Է� �� , arr ����
        int N = input.nextInt();
        int[] arr = new int[N];

        // arr ���� �Է� �ޱ�
        for(int i = 0; i < N; i++){
            arr[i] = input.nextInt();
        }

        // ã�� ���� ��°���� �Է��Ѵ�.
        int find = input.nextInt();

        // ã�� ���� ���� ��ȯ�Ѵ�.
        System.out.println(linearSelect(arr , 0 , arr.length - 1 , find));
    }
}