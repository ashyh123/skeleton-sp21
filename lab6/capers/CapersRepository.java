package capers;

import java.io.File;
import java.io.Serializable;

import static capers.Dog.DOG_FOLDER;
import static capers.Utils.*;

/** A repository for Capers 
 * @author TODO
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository implements Serializable {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = Utils.join(CWD,".capers"); // TODO Hint: look at the `join`
                                            //      function in Utils

    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {
        // TODO
        CapersRepository.CAPERS_FOLDER.mkdir();
        Dog.DOG_FOLDER.mkdir();
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {

            File Story_Fold = Utils.join(CapersRepository.CAPERS_FOLDER, "story");

            // 1. 默认老故事为空（针对第一次运行）
            String older = "";

            // 2. 如果文件存在，就把里面的内容全读出来替换掉 older
            if (Story_Fold.exists()) {
                older = Utils.readContentsAsString(Story_Fold);
            }

            // 3. 完美拼接：老故事（本身已经自带之前的换行） + 新文本 + 本次的新换行符
            String last = older + text + "\n";

            // 4. 统一使用纯文本写入工具（覆盖写入硬盘）
            Utils.writeContents(Story_Fold, last);

            // 5. 大声朗读（因为 last 末尾已经有 \n 了，所以直接用 print）
            System.out.print(last);
        // TODO;



    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        // TODO
        Dog lld1 =new Dog(name, breed, age);
        lld1.saveDog();
        System.out.println(lld1);
    }

    /**
     * çrating.
     */
    public static void celebrateBirthday(String name) {
        // TODO
        Dog lld1 = Dog.fromFile(name);
        lld1.haveBirthday();
        lld1.saveDog();

    }
}
