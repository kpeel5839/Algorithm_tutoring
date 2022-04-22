public class MyHashTable {

    // Key, Child 를 멤법 변수로 가짐
    private class Node {
        int key;
        Node child;

        // 생성자 내부에 정의
        public Node(int key, Node child) {
            this.key = key;
            this.child = child;
        }
    }

    // A 는 상수값으로 유지
    private final double A = 0.6180339887;

    // 테이블 사이즈
    private int m;

    // 적재되어 있는 원소 수
    private int n;

    // Node 변수도 가져야 하고
    private Node[] table;

    // Table 초기화
    public MyHashTable(int m) {
        this.n = 0;
        this.m = m;
        this.table = new Node[m];
    }

    // 해쉬 값을 계산
    public int hash(int key) {
        return (int) Math.floor(this.m * ((key * this.A) % 1));
    }

    public void add(int key) {

        // 해시값 얻기
        int address = hash(key);

        // load factor 를 올려주기 위해서, n++를 진행해준다.
        this.n++;

        this.table[address] = new Node(key, this.table[address]);

        // 만일 load factor 가 임계치를 넘었으면?
        if (getLoadFactor() >= 0.75) {
            // 무조건 적으로 테이블 확장
            extendTable();
        }
    }

    public void extendTable() {

        // m 2배로
        this.m *= 2;
        Node[] newTable = new Node[this.m];

        for(Node node : this.table) {

            // node 가 null 이라면 continue
            if (node == null) {
                continue;
            }

            // 현재 Node 저장
            Node cur = node;

            while (true) {
                // key 값 얻음
                int address = hash(cur.key);

                // new table 에다가 주입할 것임, 아까 위에서 key 삽입과 동일한 방법임
                newTable[address] = new Node(cur.key, newTable[address]);

                if (cur.child == null) { // cur.child 가 null 인 경우는 더 이상 뒤에 없는 것 그러면 break;
                    break;
                } else { // 그게 아니라면 ? 다음 노드로 진행
                    cur = cur.child;
                }
            } // 더 이상 Node 가 존재하지 않으면 다음으로 넘어감
        }

        // 새로 만든 table 로 갱신
        this.table = newTable;
    }

    public void printTable() {

        // 전체 테이블을 출력해야 하니, for 문으로 전체 테이블을 돌음
        for (int i = 0; i < this.table.length; i++) {
            System.out.print("table[" + i + "] = ");

            // 현재 노드를 얻음 있을 때만
            if (table[i] != null) {
                Node cur = table[i];
                while (true) {
                    // 출력
                    System.out.print(cur.key + " ");

                    if (cur.child == null) { // cur.child 가 null 인 경우는 더 이상 뒤에 없는 것 그러면 break;
                        break;
                    } else { // 그게 아니라면 ? 다음 노드로 진행
                        cur = cur.child;
                    }
                }
            }

            System.out.println();
        }
    }

    // key 검색
    public boolean contains(int key) {

        // hashing 함수를 통해서, address 얻어냄
        int address = hash(key);

        // 반환 값 초기화
        boolean result = false;

        // 해당 address 가 비어있으면 시도 조차 x
        if(table[address] != null) {

            // 시작 노드를 얻음
            Node cur = table[address];

            while (true) {
                // key 값 찾으면 break;
                if (cur.key == key) {
                    result = true;
                    break;
                }

                if (cur.child == null) { // 자식이 더 없으면, 끝
                    break;
                } else { // 자식이 더 있으면, 진행
                    cur = cur.child;
                }
            }
        }

        // key 검색 결과 반환
        return result;
    }

    public double getLoadFactor() {
        // double 값을 반환하기 위해 type casting 이후 반환
        return (double) n / (double) m;
    }
}
