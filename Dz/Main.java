import java.util.HashMap;

//    Реализовать класс работающий по принципу HashMap. Включая внутренний массив узлов с индексацией по хешу и описание узла. Добавить в класс методы:
public class Main {
    public static void main(String[] args) {
        Node node = new Node();
        Main primer = new Main();
        for (int i = 0; i < 72; i++) {
            primer.put( i + 2, i + 1);
        }
        for (Node item: primer.massiv) {
            if (item != null){
                System.out.println(item.hash + " Value = " + item.value + " Key = " + item.key + " " + item.next);
            }

        }

        System.out.println(primer.size2());
        System.out.println(primer.contaissKey2(18,19));
    }
    Node heat;
    Node[] massiv = new Node[16];
    //    int size() количество элементов
    public int size2(){
        int size = 0;
        Node node = new Node();
        node.hash = 0;
        do {if (massiv[node.hash] != null){
            Node temp = massiv[node.hash];
            while (temp != null){
                size++;
                temp = temp.next;
            }
        }
            node.hash++;
        }while (node.hash < massiv.length);
        return size;
    }
    public int size(){
        int size = 0;
        Node node = new Node();
        for (node.hash = 0; node.hash < massiv.length; node.hash++){
            if (massiv[node.hash] != null){
                Node temp = massiv[node.hash];
                while (temp != null){
                    size++;
                    temp = temp.next;
                }
            }
        }
        return size;
    }
    //    boolean containsKey(Integer key) проверка наличия ключа и значения boolean containsValue(Integer v)
    public boolean contaissKey2(Integer key, Integer value){
        Node node = new Node();
        node.hash = 0;
        do {if (massiv[node.hash] != null){
            Node temp = massiv[node.hash];
            while (temp != null){
                if (temp.key.equals(key) && temp.value.equals(value)){
                    return true;
                }
                temp = temp.next;
            }
        }
            node.hash++;
        }while (node.hash < massiv.length);
        return false;
    }
    public boolean contaissKey(Integer key, Integer value){
        Node node = new Node();
        for (node.hash = 0; node.hash < massiv.length; node.hash++){
            if (massiv[node.hash] != null){
                Node temp = massiv[node.hash];
                while (temp != null){
                    if (temp.key.equals(key) && temp.value.equals(value)){
                        return true;
                    }
                    temp = temp.next;
                }
            }
        }
        return false;
    }

    //    Object replays(Integer key, Integer v) заменить значение
    public Object replays(Integer key, Integer v){
        int index = key.hashCode()%16;
        if (massiv[index] != null) {
            Node tempNode = massiv[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    Integer x = tempNode.value;
                    tempNode.value = v;
                    return x;
                }
                tempNode = tempNode.next;
            }
        } return null;
    }
    //    Object remove(Integer key) удалить элемент с соответствующем ключём
    public Object remove(Integer key){
        int index = key.hashCode()%16;
        if (massiv[index] != null) {
            Node tempNode = massiv[index];
            if (tempNode.key == key && tempNode.next == null){
                massiv[index] = null;
                return tempNode.value;
            }
            if (tempNode.key == key && tempNode.next != null){
                massiv[index] = tempNode.next;
                return tempNode.value;
            }
            while (tempNode.next != null){
                if (tempNode.next.key == key){
                    Integer tmp = tempNode.next.value;
                    tempNode.next = tempNode.next.next;
                    return tmp;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }
    //    Object get(Integer key) получить значение соответствующее ключу
    public Object get(Object key){
        int index = key.hashCode()%16;
        if (massiv[index] != null){
            Node temp = massiv[index];
            while (temp != null){
                if (temp.key == key){
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }
//    Object put(Integer key , Integer value) добавить элемент
    public Object put(int value, int key){
        Node node = new Node();
        node.value = value;
        node.key = key;
        node.hash = node.key.hashCode()%16;
        if (massiv[node.hash] != null){
            Node temp = massiv[node.hash];
            while (temp != null){
                if (temp == node){
                    return temp.value;
                }
                temp = temp.next;
            }
            node.next = massiv[node.hash];
        } massiv[node.hash] = node;
        return null;
    }
    public void printMap(){
        for (int i = 0; i < massiv.length; i++) {
            if (massiv[i] == null){
                // System.out.println(" ");
                massiv[i] = null;
            }
            else {
                System.out.println(massiv[i].value + " " + massiv[i].key + " " + massiv[i].hash);
            }
        }
    }
    public void print(){
        Node node = heat;
        while (node != null){
            System.out.println(node.value + " " + node.key);
            node = node.next;
        }
    }

    public static class Node{
        Integer value, key;
        int hash;

        Main.Node next;
        // List<Main.Node> root = new ArrayList<>();
    }
}
