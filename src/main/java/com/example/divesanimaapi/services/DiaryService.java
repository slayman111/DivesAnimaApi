package com.example.divesanimaapi.services;

import com.example.divesanimaapi.exceptions.ObjectNotFoundException;
import com.example.divesanimaapi.exceptions.UnprocessableRequestException;
import com.example.divesanimaapi.models.dto.requests.diary.ChangeDiaryRequest;
import com.example.divesanimaapi.models.dto.requests.diary.CreateDiaryRequest;
import com.example.divesanimaapi.models.entities.Diary;
import com.example.divesanimaapi.models.entities.User;
import com.example.divesanimaapi.repositories.DiaryRepository;
import com.example.divesanimaapi.repositories.UserRepository;
import com.example.divesanimaapi.utils.PermissionsUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DiaryService {

  private final DiaryRepository diaryRepository;
  private final UserRepository userRepository;

  public List<Diary> getAll(String login, LocalDate from, LocalDate to) {
    return diaryRepository.findByDateBetweenAndUsersLogin(from, to, login);
  }

  public Diary create(CreateDiaryRequest createDiaryRequest, String login) {
    User user = userRepository.findByLogin(login).orElseThrow(ObjectNotFoundException::new);

    Set<Diary> diaries = user.getDiaries();
    Diary diary = Diary.builder()
      .record(createDiaryRequest.getRecord())
      .date(createDiaryRequest.getDate())
      .completed(false)
      .build();
    diaries.add(diary);
    user.setDiaries(diaries);

    diaryRepository.save(diary);
    userRepository.save(user);

    return diary;
  }

  public Diary change(ChangeDiaryRequest changeDiaryRequest, String login) {
    if (changeDiaryRequest.getId() == null) {
      throw new UnprocessableRequestException();
    }

    Diary diary = diaryRepository.findById(changeDiaryRequest.getId()).orElseThrow(ObjectNotFoundException::new);
    PermissionsUtil.checkUserPermissions(diary.getUsers(), login);

    if (changeDiaryRequest.getRecord() == null && changeDiaryRequest.getDate() == null) {
      diary.setCompleted(!diary.getCompleted());
    } else if (changeDiaryRequest.getRecord() == null || changeDiaryRequest.getDate() == null) {
      throw new UnprocessableRequestException();
    } else {
      diary.setRecord(changeDiaryRequest.getRecord());
    }

    diaryRepository.save(diary);

    return diary;
  }

  public Diary delete(Integer id, String login) {
    Diary diary = diaryRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
    PermissionsUtil.checkUserPermissions(diary.getUsers(), login);

    diaryRepository.delete(diary);

    return diary;
  }
}
