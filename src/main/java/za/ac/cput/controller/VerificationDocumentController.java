package za.ac.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.VerificationDocument;
import za.ac.cput.service.VerificationDocumentService;

import java.util.List;

@RestController
@RequestMapping("/api/verificationdocuments")
public class VerificationDocumentController extends BaseController<VerificationDocument> {

    private final VerificationDocumentService service;

    public VerificationDocumentController(VerificationDocumentService service) {
        this.service = service;
    }

    @Override
    protected Object getService() {
        return service;
    }

    @Override
    protected VerificationDocument createEntity(VerificationDocument entity) {
        return service.create(entity);
    }

    @Override
    protected VerificationDocument updateEntity(VerificationDocument entity) {
        return service.update(entity);
    }

    @Override
    protected VerificationDocument getEntity(Long id) {
        return service.getById(id);
    }

    @Override
    protected List<VerificationDocument> getEntities() {
        return service.getAll();
    }

    @Override
    protected void deleteEntity(Long id) {
        service.delete(id);
    }
}
