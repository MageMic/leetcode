package interview;

/**
 * @Author: zjumic
 * @Date: created at 20:42 2020/2/28
 */
public class PrintGraph {

    Integer layer;
    Character character;
    boolean insideSolid = false;

    public PrintGraph(int layer, char character, boolean insideSolid) {
        if (layer % 2 != 1) {
            throw new IllegalArgumentException("标准的菱形需要是奇数层的");
        }
        this.layer = layer;
        this.character = character;
        this.insideSolid = insideSolid;
    }

    public void draw(boolean isSolid) {
        int count = layer;

        int times = count / 2 + 1;
        for (int i = 1; i < count / 2 + 1; i++) {
                System.out.print(blank(times - i, isSolid));
                if (insideSolid) {
                    System.out.print(basic(i, isSolid));
                    System.out.print(basic(i - 1, isSolid));
                } else {
                    System.out.print(basic(1, isSolid));
                    System.out.print(blank(2 * i - 3, isSolid));
                    if (i != 1) {
                        System.out.print(basic(1, isSolid));
                    }
                }
                if (!isSolid) {
                    System.out.print(blank(times - i, isSolid));
                }
            System.out.println();
        }
        for (int i = count / 2 ; i >= 0; i--) {

            if (insideSolid) {
                System.out.print(blank(count / 2 - i, isSolid));
                System.out.print(basic(i + 1, isSolid));
                System.out.print(basic(i, isSolid));
            } else {
                System.out.print(blank(count / 2 - i, isSolid));
                System.out.print(basic(1, isSolid));
                System.out.print(blank(2 * i - 1, isSolid));
                if (i != 0) {
                    System.out.print(basic(1, isSolid));
                }
            }

            if (!isSolid) {
                System.out.print(blank(count / 2 - i, isSolid));
            }
            System.out.println();
        }
    }

    private String basic(int times, boolean isSolid) {
        StringBuffer sb = new StringBuffer();
        if (isSolid) {
            for (int i = 0; i < times; i++) {
                sb.append(Character.toString(character));
            }
        } else {
            for (int i = 0; i < times; i++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private  String blank(int times, boolean isSolid) {
        StringBuffer sb = new StringBuffer();
        if (isSolid) {
            for (int i = 0; i < times; i++) {
                sb.append(" ");
            }
        } else {
            for (int i = 0; i < times; i++) {
                sb.append(Character.toString(character));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PrintGraph pg = new PrintGraph(7, '1', false);
        pg.draw(true);
        pg.draw(false);
        pg = new PrintGraph(7, '2', true);
        pg.draw(true);
        pg.draw(false);
    }
}
