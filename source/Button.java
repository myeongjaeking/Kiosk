package source;
import javax.swing.ImageIcon;

public class Button {
     private String btnArr[]={"Coffee","Smoothie","Ade","Juice","Tea","<--","결제하기","전체취소"};
    private String coffeeNames[]={"아메리카노","바닐라라떼","카푸치노","헤이즐넛"};
    private String smoothieNames[]={"딸기스무디","블루베리스무디","망고스무디","요거트스무디"};
    private String juiceNames[]={"딸기주스","바나나주스","초코바나나","딸기바나나"};
    private String adeNames[]={"레몬에이드","자몽에이드","청포도에이드","블루레몬에이드"};
    private String teaNameStrings[]={"아이스티","얼그레이","캐모마일","자스민"};
    private String coffee_img[]={"../키오스크/img/아메.jpg","../키오스크/img/바닐라.png","../키오스크/img/카푸치노.jpg","../키오스크/img/헤이즐넛.png"};
    private String smoothie_img[]={"../키오스크/img/딸기스무디.png","../키오스크/img/블루베리스무.png","../키오스크/img/망고.png","../키오스크/img/요거트.png"};
    private String juice_img[]={"../키오스크/img/딸기.png","../키오스크/img/바나나.png","../키오스크/img/초코바나나.png","../키오스크/img/딸기바나나.jpg"};
    private String ade_img[]={"../키오스크/img/레몬.png","../키오스크/img/자몽.png","../키오스크/img/청포도.png","../키오스크/img/블루레몬.png"};
    private String tea_img[]={"../키오스크/img/아이스티.jpg","../키오스크/img/얼그레이.png","../키오스크/img/캐모마일.png","../키오스크/img/자스민.png"};
    private int price[]= {2000,2500,3000,3500};
    public Button(){} //생성자 

    public String[] getbtnArr(){return this.btnArr;}
    public String[] getCoffeeNames(){return coffeeNames;}
    public String[] getSmoothieNames(){return smoothieNames;}
    public String[] getJuiceNames(){return juiceNames;}
    public String[] getAdeNames(){return adeNames;}
    public String[] getTeaNames(){return teaNameStrings;}
    public String[] getCoffeeImgs(){return coffee_img;}
    public String[] getSmoothieImgs(){return smoothie_img;}
    public String[] getJuiceImgs(){return juice_img;}
    public String[] getAdeImgs(){return ade_img;}
    public String[] getTeaImgs(){return tea_img;}
    public int[] getPrice(){return price;}
    public int getbtnLenth(){return btnArr.length;}
    public int getLabelLenth(){return adeNames.length;}  ///메뉴 개수가 다 같아서 구냥 통일했습니다
    public int getimgLenth(){return coffee_img.length;} //이하동문
    public int getPriceArrLenth(){return price.length;} //이하동문
}