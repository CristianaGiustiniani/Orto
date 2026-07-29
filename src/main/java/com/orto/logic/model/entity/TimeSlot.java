package com.orto.logic.model.entity;

import java.time.LocalTime;

public record TimeSlot (LocalTime openingTime, LocalTime closingTime){}
