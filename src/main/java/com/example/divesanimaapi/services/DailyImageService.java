package com.example.divesanimaapi.services;

import com.example.divesanimaapi.exceptions.ObjectNotFoundException;
import com.example.divesanimaapi.models.entities.DailyImage;
import com.example.divesanimaapi.repositories.DailyImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyImageService {

  private final DailyImageRepository dailyImageRepository;

  public DailyImage create(byte[] dailyImageBytes) {
    DailyImage dailyImage = new DailyImage();
    dailyImage.setImage(dailyImageBytes);

    return dailyImageRepository.save(dailyImage);
  }

  public DailyImage delete(Integer id) {
    DailyImage dailyImage = dailyImageRepository.findById(id).orElseThrow(ObjectNotFoundException::new);

    dailyImageRepository.delete(dailyImage);

    return dailyImage;
  }
}
