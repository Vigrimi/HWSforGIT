package Lesson6HoWoCats;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson6HoWorkCatsMain
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int q = 6;
        int qM = 96;
        int[] arrSpeedMouse = new int[qM];
        int[] arrSpeedCat = new int[q];
        String[] arrCats = new String[q];
        int[] arrWeightCats = new int[q];
        //int go = 1;
        //while (go > 0)

        for (int d = 0; d < qM; d++)
        {
            Mouse mouse = new Mouse();
            mouse.setSpeedMouse();
            arrSpeedMouse[d] = (int) mouse.getSpeedMouse();
        }
        int[] arrSpeedMouseSorted = arrSpeedMouse.clone();
        Arrays.sort(arrSpeedMouseSorted);

        for (int i = 0; i < q; i++)
        {
            Cat cat = new Cat();
            cat.setNameCat();
            cat.setColourCat();
            cat.setSpeedCat();
            cat.setWeightCat();
            StringBuilder sb = new StringBuilder();
            sb = sb.append("Котейка: по имени " + cat.getNameCat()).append("; цвет: " + cat.getColourCat()).append("; скорость: " + cat.getSpeedCat() + "км/секунду; весом: ").append(cat.getWeightCat() + "кг.");
            String elemArrCats = sb.toString();

            arrSpeedCat[i] = cat.getSpeedCat();
            arrCats[i] = elemArrCats;
            arrWeightCats[i] = cat.getWeightCat();

            //System.out.println(mouse);
            //System.out.println(cat);
            //System.out.println("arrSpeedMouse: " + Arrays.toString(arrSpeedMouse));
    //        System.out.println(Arrays.toString(arrSpeedCat));
    //        System.out.println(Arrays.toString(arrCats));
            //System.out.println("gdg-- " + elemArrCats);
            //System.out.println("\nПогнали дальше? 1-да 0-нет: ");
            //go = scanner.nextInt();

        }
        int[] arrSpeedCatSorted = arrSpeedCat.clone();
        Arrays.sort(arrSpeedCatSorted);

        //System.out.println("arrSpeedMouse: " + Arrays.toString(arrSpeedMouse));
        System.out.println("\nКоты начинают ловить мышей.");
        int[] arrQtyCatchedMouses = new int[q];
        int qtyMousesGone = 0;
        for (int h = 0; h < qM; h++)
        {
            for (int j = 0; j < q; j++) {
                if (arrSpeedMouseSorted[h] < arrSpeedCatSorted[j])
                {
                    arrQtyCatchedMouses[j] += 1;
                    break;
                }
                //qtyMousesGone += arrQtyCatchedMouses[j];
            }
            System.out.println("Скорость мышки: " + arrSpeedMouseSorted[h] + " км/секунду " + '\u2708');
        }
        for (int k = 0; k < q; k++)
        {
            qtyMousesGone += arrQtyCatchedMouses[k];
            System.out.println(arrCats[k] + " Поймал " + arrQtyCatchedMouses[k] + " мышей. ");
        }
        qtyMousesGone = qM - qtyMousesGone;
        System.out.println("А убежало " + qtyMousesGone + " мышей.");
        System.out.println("\nКоты начинают отбирать мышей у других котов (если он больше противника (по весу), то может отобрать его мышей).");

        for (int n = 0; n < q; n++)
        {
            for (int m = 0; m < q; m++)
            {
                if (arrWeightCats[n] > arrWeightCats[m] && arrQtyCatchedMouses[m] > 0)
                {
                    arrQtyCatchedMouses[n] += 1;
                    arrQtyCatchedMouses[m] -= 1;
                    System.out.println(arrCats[n] + "- отобрал мышь у \n" + arrCats[m]);
                }
            }

        }
        System.out.println("\nИ в итоге получается так: ");
        for (int t = 0; t < q; t++)
        {
            System.out.println(arrCats[t] + " - имеет улов " + arrQtyCatchedMouses[t] + " мышей.");
        }
        System.out.println("\n_G A M E  O V E R_");
    }
}
