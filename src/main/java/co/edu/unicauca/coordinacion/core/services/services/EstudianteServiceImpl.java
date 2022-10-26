package co.edu.unicauca.coordinacion.core.services.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.coordinacion.core.models.EstudianteEntity;
import co.edu.unicauca.coordinacion.core.repositories.EstudianteRepository;
import co.edu.unicauca.coordinacion.core.services.DTO.EstudianteDTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private EstudianteRepository servicioAccesoBd;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EstudianteDTO> findAll() {
        List<EstudianteEntity> estudiantesEntity = this.servicioAccesoBd.findAll();
        List<EstudianteDTO> estudiantesDTO = this.modelMapper.map(estudiantesEntity, new TypeToken<List<EstudianteDTO>>() {}.getType());
        return estudiantesDTO;
    }

    @Override
    public EstudianteDTO findByCode(Integer code) {
        EstudianteEntity estudianteEntity = this.servicioAccesoBd.findByCode(code);
        EstudianteDTO estudianteDTO = this.modelMapper.map(estudianteEntity, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    public EstudianteDTO save(EstudianteDTO estudiante) {
        EstudianteEntity estudianteEntity = this.modelMapper.map(estudiante, EstudianteEntity.class);
        EstudianteEntity estudianteSaved = this.servicioAccesoBd.save(estudianteEntity);
        EstudianteDTO estudianteDTO = this.modelMapper.map(estudianteSaved, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    public EstudianteDTO update(Integer code, EstudianteDTO estudiante) {
        EstudianteEntity estudianteEntity = this.modelMapper.map(estudiante, EstudianteEntity.class);
        EstudianteEntity estudianteUpdated = this.servicioAccesoBd.update(code,estudianteEntity);
        EstudianteDTO estudianteDTO = this.modelMapper.map(estudianteUpdated, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    public boolean delete(Integer code) {
        return this.servicioAccesoBd.delete(code);
    }
    
}
