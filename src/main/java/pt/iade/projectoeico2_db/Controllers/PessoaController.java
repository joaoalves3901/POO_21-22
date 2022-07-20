package pt.iade.projectoeico2_db.Controllers;

import pt.iade.projectoeico2_db.Models.Pessoa;
import pt.iade.projectoeico2_db.Models.Repositories.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path="/api/pessoas")

public class PessoaController {
    private Logger logger = LoggerFactory.getLogger(PessoaController.class);
    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping(path = "/pedidosMonitor", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Pessoa> pedidosMonitor() {
        logger.info("Sending all pedidos for admin");
        return pessoaRepository.pedidosMonitor();
    }    

    @GetMapping(path = "/{pessoaId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Pessoa> getPessoaById(@PathVariable Integer pessoaId) {
        logger.info("Sending user with id:"+ pessoaId);
        return pessoaRepository.findPessoaId(pessoaId);    
    }


        @PostMapping(path = "/register", produces= MediaType.APPLICATION_JSON_VALUE)
        public Pessoa Register(@RequestBody Pessoa newPessoa) {
        logger.info("Saving Anuncio:"+ newPessoa.getNome());
        Pessoa pessoa = pessoaRepository.save(newPessoa);
        return pessoa;        
        }        
        
        @PostMapping(path = "/pedirMonitor", produces= MediaType.APPLICATION_JSON_VALUE)
        public int pedirMonitor(@RequestBody int pessoaId) {
        logger.info("Pedido enviado da pessoa:"+ pessoaId);
        return pessoaRepository.pedirMonitor(pessoaId);        
        }
        
        // @PostMapping("/login")
        // @ResponseBody
        // public ApiResponse<?> loginUser(@Valid @RequestBody Pessoa pessoa){
    
        //     logger.info("Inside Login User");
        //     Pessoa userEmailExists = userService.findUserByEmail(user.getEmail());
        //     Pessoa userMobileExists = userService.findUserByMobile((user.getMobile()));
        //     String existingPassword =userEmailExists.getPassword();
        //     String currentPassword=pessoa.getPassword();
    
        //     if (userEmailExists.getEmail().isEmpty()) {
        //         return new ApiResponse<>("\"Oops.! User email not found, please register.\"", com.bfarming.response.ResponseStatus.getValidResponseStatus(HttpStatus.OK));
        //     }else if(userMobileExists.getMobile().isEmpty()){
        //         return new ApiResponse<>("\"Oops.! User mobile not found, please register.\"", com.bfarming.response.ResponseStatus.getValidResponseStatus(HttpStatus.OK));
        //     }else if (bcryptGenerator.passwordDecoder(currentPassword,existingPassword)) {
        //         return new ApiResponse<>("\"Password Exists, logged-in\"");
        //     }else {
        //         return new ApiResponse<>("\"Password didn't match, please enter the correct password, logged-in\"");
        //     }
        // }
    }

