package org.d3if4080.test_assesment2_muhammaddaffa6706204080.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "table_resource")
data class History (@PrimaryKey (autoGenerate = true)
                        var id : Int = 0,
                    var celcius : Int = 0,
                    var fahrenheit : Int = 0,)

