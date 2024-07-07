package dev.ardijorganxhi.shkruajshqip.service;

import dev.ardijorganxhi.shkruajshqip.repository.EntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntryService {

    private final EntryRepository entryRepository;


}
