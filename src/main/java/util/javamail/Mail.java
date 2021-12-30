/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.javamail;

/**
 *
 * @author ADMIN
 */
public abstract class  Mail{
    protected String username;
    protected String password;

    public Mail(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
}
