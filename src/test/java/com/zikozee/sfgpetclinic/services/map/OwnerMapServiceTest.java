package com.zikozee.sfgpetclinic.services.map;

import com.zikozee.sfgpetclinic.model.Owner;
import com.zikozee.sfgpetclinic.model.PetType;
import com.zikozee.sfgpetclinic.services.PetService;
import com.zikozee.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Owner Map Service Test - ")
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService  = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        System.out.println("First Before Each");
    }

    @Test
    void ownerAreZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();
    }

    @DisplayName("Pet Type - ")
    @Nested
    class TestCreatePetTypes{

        @BeforeEach
        void setUp() {
            PetType petType = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");
            petTypeService.save(petType);
            petTypeService.save(petType2);

            System.out.println("Nested Before Each");
        }

        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();

            assertThat(petTypeCount).isNotZero().isEqualTo(2);
        }

        @DisplayName("Save Owners Tests - ")
        @Nested
        class SaveOwnersTests{

            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L,  "Before", "Each"));

                System.out.println("Save Owners Before Each");
            }

            @Test
            void saveOwner() {
                Owner owner = new Owner(2L, "Joe", "Buck");

                Owner savedOwner  = ownerMapService.save(owner);

                assertThat(savedOwner).isNotNull();
            }

            @DisplayName("Save Owners Tests - ")
            @Nested
            class FindOwnersTests{

                @DisplayName("Find Owner")
                @Test
                void findOwner() {

                    Owner foundOwner = ownerMapService.findById(1L);

                    assertThat(foundOwner).isNotNull();
                }

                @Test
                void findOwnerNotFound() {

                    Owner owner = ownerMapService.findById(2L);

                    assertThat(owner).isNull();
                }
            }
        }
    }


    @Test
    void ownerAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertThat(ownerCount).isZero();
    }
}