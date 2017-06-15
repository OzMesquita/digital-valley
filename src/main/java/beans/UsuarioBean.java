package beans;

public class UsuarioBean {
    private String login;
    private String senha;
    private String nivel;
    
    
    public UsuarioBean(){
    }

    public UsuarioBean(String login, String senha, String nivel) {
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
    }
    
   public void setLogin(String login){
       this.login = login;
   }
   public String getLogin(){
       return login;
   }
   public void setSenha(String senha){
       this.senha = senha;
   }
   public String getSenha(){
       return senha;
   }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
}
