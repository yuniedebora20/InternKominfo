package intern.kominfo.webprofile.service;

import intern.kominfo.webprofile.model.SejarahModel;
import intern.kominfo.webprofile.repository.SejarahDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SejarahServiceImpl implements SejarahService{
    @Autowired
    SejarahDb sejarahDb;

    @Override
    public void addSejarah(SejarahModel sejarah){sejarahDb.save(sejarah);}

    @Override
    public SejarahModel getSejarahById(Long id){
        return sejarahDb.findById(id).get();
    }

    @Override
    public SejarahModel updateSejarah(SejarahModel sejarah){
        SejarahModel targetSejarah = sejarahDb.findById(sejarah.getId()).get();

        try{
            targetSejarah.setScript(sejarah.getScript());
            targetSejarah.setUpdated(sejarah.getUpdated());
            sejarahDb.save(targetSejarah);
            return targetSejarah;
        } catch (NullPointerException nullException){
            return null;
        }
    }
}
