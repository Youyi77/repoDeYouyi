package com.adaming.myapp.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Qualif")
public class TournoisQualification extends Tournois{

}
