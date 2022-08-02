package br.edu.ifms.estudante.alvaro.detran.configs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.edu.ifms.estudante.alvaro.detran.models.RoleModel;

@Entity
@Table(name = "tb_usuario")
public class DetailUserData implements UserDetails, Serializable{


    
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtb_usuario")
	private Integer id;
	@Column(nullable = false, unique = true, length = 12)
	private String cpf;
	@Column(nullable = false, length = 50)
	private String senha;


    @ManyToMany
	//@JsonBackReference
	@JoinTable(name = "tb_usuario_role", 
			joinColumns = @JoinColumn(name = "idtb_usuario", referencedColumnName = "idtb_usuario"), 
			inverseJoinColumns = @JoinColumn(name = "idtb_role", referencedColumnName = "idtb_role"))
	private List<RoleModel> roles = new ArrayList<>();

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for(RoleModel role : this.roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
    	return authorities;
	}
	
	@Override
	public String getPassword() {
		return this.senha;
	}
	
	@Override
	public String getUsername() {
		return this.cpf;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }

    public void addRole(RoleModel role){
		this.roles.add(role);
	}
    
}
