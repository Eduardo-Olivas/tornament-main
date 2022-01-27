package net.atos.crojo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.crojo.model.Registro;
import net.atos.crojo.repo.BaseRepository;
import net.atos.crojo.repo.RegistroRepository;

@Service
public class RegistroServiceImpl extends BaseServiceImpl<Registro, Long> implements RegistroService {

    @Autowired
    private RegistroRepository autorRepository;

    public RegistroServiceImpl(BaseRepository<Registro, Long> baseRepository) {
        super(baseRepository);
    }
}