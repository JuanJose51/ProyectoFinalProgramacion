package co.edu.uniquindio.proyectofinalprogramacion.controller;

import co.edu.uniquindio.proyectofinalprogramacion.model.hospital.Hospital;

public class LoginController {
    Hospital hospital;
    public LoginController(Hospital h){this.hospital=h;}
    public boolean exiteUser(String tipoUser,String id){
        if(tipoUser.equals("Paciente")){
            return hospital.existePaciente(id);
        }else if(tipoUser.equals("Medico")){
            return hospital.existeMedico(id);
        } else{
            return hospital.getAdministrador().getId().equals(id);
        }
    }
}
