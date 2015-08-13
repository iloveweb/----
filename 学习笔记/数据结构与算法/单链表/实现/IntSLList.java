package ������;
//����������
public class IntSLList {

	private IntNode head,tail;
	private int length;
	public int getLength() {
		return length;
	}
	public IntSLList(){      //���캯������ʼ��head��tail,length;
		this.head=null;
		this.tail=null;
		length=0;
	}
	public boolean isEmpty(){   //�ж��Ƿ�Ϊ������
		return head==null;
	}
	public void addToHead(int value){   //��head�ڵ�ǰ����ֵΪvalue���½ڵ�
		head=new IntNode(value,head);
		if(tail==null){
			tail=head;
		}
		length++;
	}
	public void addToTail(int value){  //��tail�ڵ�����ֵΪvalue���½ڵ�
		if(this.isEmpty())
			head=tail=new IntNode(value);
		else{
			tail.next=new IntNode(value);
			tail=tail.next;
		}
		length++;
	}
	public int deleteFromHead(){    //ɾ��ͷ�ڵ㣬����ͷ�ڵ�value��Ϣ
		int value=head.value;
		if(head==tail)
			head=tail=null;
		else
			head=head.next;
		length--;
		return value;
	}
	public int deleteFromTail(){
		int value=tail.value;
		if(head==tail)
			head=tail=null;
		else{
			IntNode temp;
			for(temp=head;temp.next!=tail;temp=temp.next);  //��ѭ����ּ���ƶ�temp
			tail=temp;
			tail.next=null;
		}
		length--;
		return value;
	}
	public void printAll(){
		if(this.isEmpty())
			System.out.println("������Ϊ�գ�");
		else{
			IntNode temp=head;
			System.out.print("������Ϊ��");
		    while(temp!=null){
			System.out.print(temp.value+"  ");
			temp=temp.next;
		    }
		    System.out.println();
		}
	}
	public boolean isInList(int value){
		IntNode temp=head;
		boolean b=false;
		while(temp!=null){
			if(temp.value==value){
				b=true;
				break;
			}
			temp=temp.next;
		}
		return b;
	}
	public void deleteByValue(int value){ //���ݽڵ�ֵɾ���ڵ�
		int flag=0;
	    if(head.value==value&&head==tail){      //���ֻ��һ���ڵ�
	    	head=tail=null;
	    	flag=1;
	    }      
	    else if(head.value==value){            //��ֹһ���ڵ㣬��Ŀ�ؽڵ���ͷ�ڵ�
	    	head=head.next;
	    	flag=1;
	        }
	    else{                                  //��ֹһ���ڵ㣬Ŀ�ؽڵ㲻��ͷ�ڵ�
	    	   IntNode temp,pred;
	    	   for(pred=head,temp=head.next;temp!=null&&temp.value!=value;temp=temp.next,pred=pred.next);
	    	   if(temp!=null){
	    		   pred.next=temp.next;
	    		   flag=1;
	    	   }
	        }
	    if(flag==1){
	    	System.out.println("Ԫ��"+value+"ɾ���ɹ���");
	    	length--;
	    }
	    else
	    	System.out.println("Ԫ��"+value+"���������У�");
	}
	public int deleteByIndex(int index){  //�����±�ɾ���ڵ�
		int deleteValue=index;
		if(this.isEmpty()){
			System.out.print("�������޷�����ɾ��������");
			return deleteValue;
		}
		else if(index>-1&&index<this.length){
			if(index==0)
				deleteValue=this.deleteFromHead();
			else if(index==this.length-1)
				deleteValue=this.deleteFromTail();
			else{
				IntNode temp=head;
				int i=0;
				for(i=0;i<index-1;i++){
					temp=temp.next;
				}
				deleteValue=temp.next.value;
				temp.next=temp.next.next;
				length--;
			}
		}
		else{
			System.out.println("�±�Խ��");
		}
		return deleteValue;
	}
    public void reverseList(){         //��ת����
    	IntNode p=head,q=null,r=null,m=null;
    	if(!this.isEmpty()){
    		if(this.length==1)
    			q=p;
    		else if(this.length==2){
    			q=p.next;
    			q.next=p;
    			p.next=null;
    		}
    		else{
    			q=p.next;
    			r=q.next;
    			while(q!=null&&r!=null){
    				q.next=p;
    				p.next=m;
    				m=p;
    				p=q;
    				q=r;
    				r=r.next;
    			}
    			q.next=p;
    		}
    		head=q;
    	}
    	else{
    		System.out.println("����Ϊ�գ�");
    	}
    }
    public void insertByValue(int value,int insertValue){  //��valueǰ����insertValue
    	if(this.isInList(value)){
    		IntNode p=head,q=null;
    		if(p.value==value)
    			this.addToHead(insertValue);
    		else{
    			q=p.next;
    			while(q!=null){
    				if(q.value==value)
    					break;
    				else{
    					q=q.next;
    					p=p.next;
    				}
    			}
    			IntNode valueNode=new IntNode(insertValue);
    			valueNode.next=q;
    			p.next=valueNode;
    		    length++;
    		}
    	}
    	else{
    		System.out.print("Ԫ��"+value+"���������У�");
    	}
    }
    public void insertByIndex(int index,int insertValue){
    	if(!this.isEmpty()){
    		if(index>-1&&index<this.length){
    			if(index==0)
    				this.addToHead(insertValue);
    			else{
    				IntNode p=head,q=null;
    				int j=0;
    				for(j=0;j<index-1;j++)
    					p=p.next;
    				q=p.next;
    				IntNode insertNode=new IntNode(insertValue);
    				insertNode.next=q;
    				p.next=insertNode;
    				length++;
    			}
    		}
    		else
    			System.out.print("�±�Խ�磡");
    	}
    	else
    		System.out.print("����Ϊ�գ�");
    }
}
