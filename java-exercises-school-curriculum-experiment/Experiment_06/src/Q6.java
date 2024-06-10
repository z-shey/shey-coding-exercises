
/**
 * @Project_Name: Java programming course in school
 * @Package_Name: PACKAGE_NAME
 * @File:
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Created: 2023-10-28 13:02
 * @Last_Modified: 2023-10-28 13:02
 * @Description: No Description.
 */

import java.util.*;
class GiftGenerator<T> {
    private T gift;
    private final Collection<T> giftList;

    public GiftGenerator() {
        giftList = new ArrayList<>();
    }

    public void addGift(T gift) {
        giftList.add(gift);
    }

    public T getGift() {
        return new ArrayList<>(giftList).get(new Random().nextInt(giftList.size()));
    }
}


class BirthdayGiftLottery {
    public static void main(String[] args) {
        GiftGenerator<String> giftGenerator = new GiftGenerator<>();

        giftGenerator.addGift("MP3");
        giftGenerator.addGift("MP4");
        giftGenerator.addGift("Phone");
        giftGenerator.addGift("Computer");

        System.out.println("Gift is " + giftGenerator.getGift());
    }
}

public class Q6 {

}
