package org.rgrThalles.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddressResponse {

    private Meta meta;
    private Result result;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Meta {
        private int currentPage;
        private int itemsPerPage;
        private int totalOfItems;
        private int totalOfPages;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {
        private String street;
        private String complement;
        private String district;
        private String districtId;
        private String city;
        private String cityId;
        private String ibgeId;
        private String state;
        private String stateIbgeId;
        private String stateShortname;
        private String zipcode;

    }
}
