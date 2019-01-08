package apirest;

import apirest.domain.Categoria;
import apirest.domain.Cidade;
import apirest.domain.Estado;
import apirest.domain.Produto;
import apirest.repositories.CategoriaRepository;
import apirest.repositories.CidadeRepository;
import apirest.repositories.EstadoRepository;
import apirest.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Produto p1= new Produto(null,"Computador",2000.00);
        Produto p2=new Produto(null, "Impressora", 800.00);
        Produto p3=new Produto(null, "Mouse", 80.00);
        Categoria cat1 = new Categoria(null, "Informatica");
        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));

        Categoria cat2 = new Categoria(null, "Escritorio");
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

        Estado e1=new Estado(null,"Minas Gerais");
        Estado e2=new Estado(null,"São paulo");

        Cidade c1= new Cidade(null,"Uberlandia",e1);
        Cidade c2= new Cidade(null,"Uberlandia",e2);
        Cidade c3= new Cidade(null,"Campinas",e2);

        e1.getCidades().addAll(Arrays.asList(c1));
        e2.getCidades().addAll(Arrays.asList(c2,c3));

        estadoRepository.saveAll(Arrays.asList(e1,e2));
        cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
    }
}
