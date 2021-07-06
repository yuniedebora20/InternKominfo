package intern.kominfo.webprofile.service;

import intern.kominfo.webprofile.model.SejarahModel;

public interface SejarahService {
    //method untuk tambah sejarah
    void addSejarah (SejarahModel sejarah);

    //method untuk update sejarah
    SejarahModel updateSejarah (SejarahModel sejarah);

    //method retrieve sejarah
    SejarahModel getSejarahById(Long idSejarah);
}
