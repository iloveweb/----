package ������;
//�������Ľڵ���
public class IntNode {
    public int value;
	public IntNode next;
	public IntNode(int value){
		this(value,null);      //���������һ�����캯��
	}
	public IntNode(int value,IntNode next){
		this.value=value;
		this.next=next;
	}
}
