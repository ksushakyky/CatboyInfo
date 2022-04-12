//package controller;
//
//import com.zaxxer.hikari.HikariDataSource;
//import model.Client;
//import model.ClientRepository;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Configuration
////@EnableAutoConfiguration
//
//public class AppConfig {
//
//
//
//
//
////    @Bean(name="entityManagerFactory")
////    public LocalSessionFactoryBean sessionFactory() {
////        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
////
////        return sessionFactory;
////    }
////    @Bean
////    @ConfigurationProperties
////    public ClientRepository clientRepository() {
////        return new ClientRepository() {
////
////            @Override
////            public <S extends Client> S save(S entity) {
////                return null;
////            }
////
////            @Override
////            public <S extends Client> Iterable<S> saveAll(Iterable<S> entities) {
////                return null;
////            }
////
////            @Override
////            public Optional<Client> findById(Long aLong) {
////                return Optional.empty();
////            }
////
////            @Override
////            public boolean existsById(Long aLong) {
////                return false;
////            }
////
////            @Override
////            public Iterable<Client> findAll() {
////                return null;
////            }
////
////            @Override
////            public Iterable<Client> findAllById(Iterable<Long> longs) {
////                return null;
////            }
////
////            @Override
////            public long count() {
////                return 0;
////            }
////
////            @Override
////            public void deleteById(Long aLong) {
////
////            }
////
////            @Override
////            public void delete(Client entity) {
////
////            }
////
////            @Override
////            public void deleteAllById(Iterable<? extends Long> longs) {
////
////            }
////
////            @Override
////            public void deleteAll(Iterable<? extends Client> entities) {
////
////            }
////
////            @Override
////            public void deleteAll() {
////
////            }
////        };
////    }
//
//
//
//}
