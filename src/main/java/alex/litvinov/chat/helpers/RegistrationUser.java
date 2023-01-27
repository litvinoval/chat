package alex.litvinov.chat.helpers;


import alex.litvinov.chat.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class RegistrationUser {

    @Size(min = 4, message = "Login must be 4 character length at least")
    private String login;
    @NotNull
    @Size(min = 4, message = "Password must be 4 character length at least")
    private String password;

    @Size(min = 4, message = "Nick must be 4 character length at least")
    private String nick;

    public RegistrationUser(){}
    public User convertToUser(PasswordEncoder pw){
        return new User(
                this.login,
                pw.encode(this.password),
                this.nick
        );
    }


}
