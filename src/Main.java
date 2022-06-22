import java.util.EmptyStackException;
//Stack 은 LIFO Last In first Out  다 바로 넣었다가 거꾸로 정렬된 데이터를 꺼내 쓰는데에 좋다.
//Stack 의 4가지 기능
// pop() 맨 마지막에 들어간 데이터를 가져오면서 지우는 것
// push() 새로운 데이터를 맨 위에 한개 더 쌓는 것
// peek() 맨 마지막 데이터를 보는 것
// is Empty() stack 에 데이터가 있는지 없는지 확인 하는 것
class Stack<T> { //객체를 만들때 <T> 타입 데이터타입을 명시하고
    class Node<T> {// 같은 타입을 받는 노드를 선언
        private T data; // data 선언
        private Node<T> next; // 다음 노드도 선언

        public Node(T data) { //생성자에서 해당 타입의 데이터를 하나 받아서
            this.data = data; // 내부 변수에 저장
        }
    }
    private Node<T> top; //멤버 변수 선언 스택은 맨위에 올라가 있는 데이터만 알고 있으면 된다.

    public T pop() { // 가장 위에 있는 Node 를 가져오는 함수
        if (top == null) { // 탑에 있는 data 를 가져오면 되는데 만약 top 이 null 이면
            throw new EmptyStackException();
        }// 아니라면 맨위에 있는 데이터를 반환하기 전에 그 다음주소에 있는 데이터를 탑으로 만들어 줘야한다.
        T item = top.data; // 데이터를 백업하고
        top = top.next; //다음 데이터를 탑으로 만들어준다.
        return item; // 그리고 데이터를 반환
    }
    public void push(T item){
        Node<T> t = new Node<T>(item);//push 할 T 타입의 아이템을 하나 받아서 이 아이템을 가지고 node를 생성한다.
        t.next = top; // top 앞에 그 노드를 위치시키고
        top = t; // 해당 노드가 탑이된다.
    }
    public T peek(){ // T 타입의 데이터를 반환하고
        if (top == null) { // 마찬가지로 null 체크
            throw new EmptyStackException();// top이 null 이면 에러
        }
        // null 이아니면
        return top.data; // 현재 top 이 갖고있는 데이터를 반환한다.
    }
    public boolean isEmpty(){
        return top == null; // top 이 null 이면  ture
    }
}
public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop()); // 가져오고 4
        System.out.println(s.pop()); // 가져오고 3
        System.out.println(s.peek()); // 보고 2
        System.out.println(s.pop()); // 가져오고 2
        System.out.println(s.isEmpty()); // 비어있는지 확인 false
        System.out.println(s.pop()); // 가져오고 1
        System.out.println(s.isEmpty()); // 또 확인 true
    }
}