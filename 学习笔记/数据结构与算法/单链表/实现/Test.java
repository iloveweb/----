package µ•¡¥±Ì;
//≤‚ ‘¿‡
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IntSLList l=new IntSLList();
		IntSLList m=new IntSLList();
        //≤‚ ‘isEmpty()
		System.out.println(l.isEmpty());
		l.addToHead(1);
		System.out.println(l.isEmpty());
		//≤‚ ‘getLength()
		System.out.println(l.getLength());
		System.out.println(m.getLength());
		//≤‚ ‘printAll()
		l.printAll();
		m.printAll();
		//≤‚ ‘addToHead(int value)
		l.addToHead(2);
		l.printAll();
		//≤‚ ‘deleteFromHead()
		int dele=l.deleteFromHead();
		System.out.println("…æ≥˝‘™ÀÿŒ™£∫"+dele);
		l.printAll();
		int dele1=l.deleteFromHead();
		System.out.println("…æ≥˝‘™ÀÿŒ™£∫"+dele1);
		l.printAll();
		//≤‚ ‘addToTail(int value)
		m.addToTail(1);
		m.addToTail(2);
		m.printAll();
		//≤‚ ‘deleteByIndex(int index)
		m.deleteByIndex(0);
		m.printAll();
		m.deleteByIndex(0);
		m.printAll();
		m.addToTail(1);
		m.addToTail(2);
		m.addToTail(3);
		m.addToTail(4);
		m.printAll();
		m.deleteByIndex(1);
		m.printAll();
		m.deleteByIndex(2);
		m.printAll();
		m.deleteByIndex(2);
		m.printAll();
	}

}
