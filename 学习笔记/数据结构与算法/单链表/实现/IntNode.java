package 单链表;
//组成链表的节点类
public class IntNode {
    public int value;
	public IntNode next;
	public IntNode(int value){
		this(value,null);      //调用下面的一个构造函数
	}
	public IntNode(int value,IntNode next){
		this.value=value;
		this.next=next;
	}
}
