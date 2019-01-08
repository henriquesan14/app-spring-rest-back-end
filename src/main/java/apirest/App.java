package apirest;

import apirest.domain.Categoria;
import apirest.domain.Produto;
import apirest.repositories.CategoriaRepository;
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
    }
}
