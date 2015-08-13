package 单链表;
//单链链表类
public class IntSLList {

	private IntNode head,tail;
	private int length;
	public int getLength() {
		return length;
	}
	public IntSLList(){      //构造函数，初始化head和tail,length;
		this.head=null;
		this.tail=null;
		length=0;
	}
	public boolean isEmpty(){   //判断是否为空链表
		return head==null;
	}
	public void addToHead(int value){   //在head节点前插入值为value的新节点
		head=new IntNode(value,head);
		if(tail==null){
			tail=head;
		}
		length++;
	}
	public void addToTail(int value){  //在tail节点后插入值为value的新节点
		if(this.isEmpty())
			head=tail=new IntNode(value);
		else{
			tail.next=new IntNode(value);
			tail=tail.next;
		}
		length++;
	}
	public int deleteFromHead(){    //删除头节点，返回头节点value信息
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
			for(temp=head;temp.next!=tail;temp=temp.next);  //空循环，旨在移动temp
			tail=temp;
			tail.next=null;
		}
		length--;
		return value;
	}
	public void printAll(){
		if(this.isEmpty())
			System.out.println("单链表为空！");
		else{
			IntNode temp=head;
			System.out.print("单链表为：");
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
	public void deleteByValue(int value){ //根据节点值删除节点
		int flag=0;
	    if(head.value==value&&head==tail){      //如果只有一个节点
	    	head=tail=null;
	    	flag=1;
	    }      
	    else if(head.value==value){            //不止一个节点，但目地节点在头节点
	    	head=head.next;
	    	flag=1;
	        }
	    else{                                  //不止一个节点，目地节点不再头节点
	    	   IntNode temp,pred;
	    	   for(pred=head,temp=head.next;temp!=null&&temp.value!=value;temp=temp.next,pred=pred.next);
	    	   if(temp!=null){
	    		   pred.next=temp.next;
	    		   flag=1;
	    	   }
	        }
	    if(flag==1){
	    	System.out.println("元素"+value+"删除成功！");
	    	length--;
	    }
	    else
	    	System.out.println("元素"+value+"不再链表中！");
	}
	public int deleteByIndex(int index){  //根据下标删除节点
		int deleteValue=index;
		if(this.isEmpty()){
			System.out.print("空链表，无法进行删除操作！");
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
			System.out.println("下标越界");
		}
		return deleteValue;
	}
    public void reverseList(){         //反转链表
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
    		System.out.println("链表为空！");
    	}
    }
    public void insertByValue(int value,int insertValue){  //在value前插入insertValue
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
    		System.out.print("元素"+value+"不在链表中！");
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
    			System.out.print("下标越界！");
    	}
    	else
    		System.out.print("链表为空！");
    }
}
