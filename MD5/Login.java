import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Dicionário usuário → hash da senha
        Dictionary<String, String> dict = new Hashtable<>();
        dict.put("teste", "523b06c9d2baf8c0396e1cb274a792f9");  // hash de "123456"

        System.out.print("Digite seu usuário: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu password: ");
        String pass = sc.nextLine();

        
        String hashDigitado = Md5Util.toMd5(pass);

        // Verificar se usuário existe
        if (dict.get(nome) == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        // Verificar senha
        if (dict.get(nome).equals(hashDigitado)) {
            System.out.println("Login autorizado! 🚀");
        } else {
            System.out.println("Senha incorreta!");
        }
    }
}

