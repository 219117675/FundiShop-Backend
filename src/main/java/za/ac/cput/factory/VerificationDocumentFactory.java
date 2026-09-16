package za.ac.cput.factory;

import za.ac.cput.domain.FundiProfile;
import za.ac.cput.domain.VerificationDocument;

public final class VerificationDocumentFactory {

    private VerificationDocumentFactory() {
    }

    public static VerificationDocument create(FundiProfile fundiProfile,
                                                              String documentType, String fileUrl) {
            return VerificationDocument.builder()
                    .fundiProfile(fundiProfile)
                    .documentType(documentType)
                    .fileUrl(fileUrl)
                    .build();
        }

}