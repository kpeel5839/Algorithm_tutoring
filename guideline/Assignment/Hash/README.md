정수 키값을 저장하는 해시테이블 클래스를 정의하고 이용하는 프로그램을 작성하세요.
 
- 입력: 없음
- 출력: 키값의 검색 결과, 적재율, 해시테이블 상태
 
- 메인 클래스 
main 메소드는 다음을 수행 ** 첨부한 파일을 그대로 사용해도 됨
(1) 입력 없이 실행하기 위해 해시 테이블에 저장할 key와 삽입할 key를 배열에 다음과 같이 수록해 둠
int[] addArray = {1, 5, 7, 9, 2, 4, 6, 8, 10, 30, 40};
int[] searchArray = {4, 6, 8, 10, 30, 40, 1, 5, 7, 9, 2, 111, 333};
(2) 테이블 크기가 8인 MyHashTable 객체를 생성(hashTable)
(3) hashTable에 addArray의 key를 모두 삽입
(4) hashTable에 제대로 삽입되었는지 확인하기 위해 현재 테이블 상태와 적재율을 출력
(5) hashTable에서 searchArray의 각 key를 조회하여 결과 true/false를 출력 
 
- MyHashTable 클래스 - 정수 key값들을 저장하는 해시 테이블 클래스 ** 힌트가 필요한 경우 첨부한 파일에서 (1) ~ (5) 부분을 완성하면 됨
해시함수는 곱하기 방법(A = 0.6180339887), 충돌해결은 체이닝을 이용 ** 체이닝에 사용하는 단순 연결리스트는 직접 구현해야 함
 
private 클래스:
   노드 구조를 나타내는 Node 클래스
private 인스턴스 변수:
   해시테이블 - Node형 배열
   해시테이블 크기  
   저장된 원소 수 
private 메소드:
   hash - 해시 함수. 곱하기 방법을 사용하되, A = 0.6180339887로 할 것
public 메소드:
   생성자 - 해시테이블 크기를 매개변수로 받아 공백 해시테이블 생성
   getLoadFactor - 현재 적재율을 계산하여 리턴
   add - key 값을 저장
          key 중복 문제는 고려하지 않아도 됨. 따라서 해싱된 위치의 연결리스트 맨 앞에 삽입하면 됨
          (A) 적재율 상관 없이 삽입해도 되고,
          (B) 또는 삽입 전에 적재율을 검사하여 0.75를 초과하는 경우 테이블 크기를 2배 확장한 후 삽입하도록 해도 됨
   contains - key를 검색하여 존재 여부를 리턴
          테이블 전체를 검색하면 안되고, 해싱된 위치의 연결리스트 하나만 검색해야 함
   printTable - 과제 수행을 올바르게 했는지 확인하기 위해 테이블 전체 상태를 출력하는 메소드 
          주의: toString을 정의한다면 저장한 내용만 리턴하겠지만, printTable은 구현 세부 사항 확인을 위해 비어있는 항목도 포함해서 테이블 전체를 출력
   
  
- 실행 예(A):
hw7_1 : 홍길동
table[0] = 5 
table[1] = 10 2 
table[2] = 7 
table[3] = 4 
table[4] = 30 9 1 
table[5] = 40 6 
table[6] = 
table[7] = 8 
load factor = 1.375
true true true true true true true true true true true false false 
 
 
- 실행 예(B):
hw7_1 : 홍길동
table[0] = 
table[1] = 5 
table[2] = 10 
table[3] = 2 
table[4] = 
table[5] = 7 
table[6] = 
table[7] = 4 
table[8] = 30 9 
table[9] = 1 
table[10] = 
table[11] = 40 6 
table[12] = 
table[13] = 
table[14] = 
table[15] = 8 
load factor = 0.6875
true true true true true true true true true true true false false 
-----------------------------------
목적
- 해시테이블 구조와 해시함수, 충돌해결 방법을 이해한다.
   
-----------------------------------
유의사항
- 적절한 comment
- 들여쓰기 철저히 할 것
- 식별자 이름을 자바 관례에 맞게 적절히 붙일 것
- 프로그램 맨 앞에 과제코드와 본인의 이름을 출력할 것
- 입출력 형식을 실행 예와 동일하게 할 것
  
-----------------------------------
제출
- 소스코드파일(.java)
- 실행가능한 jar 파일(과제코드.jar) 
- LMS 과제 제출시 설명란에 이번 과제 수행에 관해 다음 항목을 적으세요. (1점) -- 프로그램을 제출해야 1점
     (1) 소요 시간 
     (2) 도움 받은 정도
     (3) 어려운 점
     (4) 느낀 점

### hint

// 정수형 해시 테이블인 MyHashTable 클래스를 정의하고 사용하는 프로그램
public class MyHashTableTest {
   public static void main(String[] args) {
      System.out.println("hw7_1 : 홍길동");

      // 입력 없이 실행하기 위해 해시 테이블에 저장할 key들을 배열에 다음과 같이 수록해 둠
      int[] addArray = {1, 5, 7, 9, 2, 4, 6, 8, 10, 30, 40};
      int[] searchArray = {4, 6, 8, 10, 30, 40, 1, 5, 7, 9, 2, 111, 333};

      // 테이블 크기가 8인 MyHashTable 객체를 생성(hashTable)
      MyHashTable hashTable = new MyHashTable(8);

      // hashTable에 addArray의 key를 모두 삽입
      for(int key: addArray) {
         hashTable.add(key);   
      }   

      // hashTable에 제대로 삽입되었는지 확인하기 위해 현재 테이블 상태와 적재율을 출력
      hashTable.printTable();
      System.out.println("load factor = " + hashTable.getLoadFactor());

      // hashTable에서 searchArray의 각 key를 조회하여 결과 true/false를 출력 
      for(int key: searchArray) {
         System.out.print(hashTable.contains(key) + " ");   
      }
   }
}
