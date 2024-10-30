import com.chh.models.dtos.Team.CreateTeamDTO;
import com.chh.models.dtos.Team.TeamDTO;
import com.chh.models.dtos.Team.UpdateTeamDTO;
import com.chh.models.entities.Team;
import com.chh.models.mappers.TeamMapper;
import com.chh.repository.TeamRepository;
import com.chh.services.implementation.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private TeamMapper teamMapper;

    @InjectMocks
    private TeamService teamService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTeam() {
        List<Team> mockTeams = Arrays.asList(new Team(), new Team());
        List<TeamDTO> mockTeamDTOs = Arrays.asList(new TeamDTO(), new TeamDTO());

        when(teamRepository.findAll()).thenReturn(mockTeams);
        when(teamMapper.toDTOs(mockTeams)).thenReturn(mockTeamDTOs);

        List<TeamDTO> result = teamService.getAllTeam();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(teamRepository).findAll();
        verify(teamMapper).toDTOs(mockTeams);
    }

    @Test
    public void testGetTeamById_Success() {
        Team mockTeam = new Team();
        TeamDTO mockTeamDTO = new TeamDTO();

        when(teamRepository.findById(1L)).thenReturn(Optional.of(mockTeam));
        when(teamMapper.toDTO(mockTeam)).thenReturn(mockTeamDTO);

        TeamDTO result = teamService.getTeamById(1L);

        assertNotNull(result);
        verify(teamRepository).findById(1L);
        verify(teamMapper).toDTO(mockTeam);
    }

    @Test
    public void testGetTeamById_NotFound() {
        when(teamRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> teamService.getTeamById(1L));
        assertEquals("Le team avec l'ID 1 n'existe pas.", exception.getMessage());

        verify(teamRepository).findById(1L);
        verify(teamMapper, never()).toDTO(any(Team.class));
    }

    @Test
    public void testCreateTeam() {
        CreateTeamDTO createTeamDTO = new CreateTeamDTO();
        Team mockTeam = new Team();
        Team savedTeam = new Team();
        TeamDTO mockTeamDTO = new TeamDTO();

        when(teamMapper.toEntity(createTeamDTO)).thenReturn(mockTeam);
        when(teamRepository.save(mockTeam)).thenReturn(savedTeam);
        when(teamMapper.toDTO(savedTeam)).thenReturn(mockTeamDTO);

        TeamDTO result = teamService.createTeam(createTeamDTO);

        assertNotNull(result);
        verify(teamMapper).toEntity(createTeamDTO);
        verify(teamRepository).save(mockTeam);
        verify(teamMapper).toDTO(savedTeam);
    }

    @Test
    public void testUpdateTeam_Success() {
        UpdateTeamDTO updateTeamDTO = new UpdateTeamDTO();
        Team mockTeam = new Team();
        Team updatedTeam = new Team();
        TeamDTO mockTeamDTO = new TeamDTO();

        when(teamRepository.findById(1L)).thenReturn(Optional.of(mockTeam));
        doNothing().when(teamMapper).updateTeamFromDto(updateTeamDTO, mockTeam);
        when(teamRepository.save(mockTeam)).thenReturn(updatedTeam);
        when(teamMapper.toDTO(updatedTeam)).thenReturn(mockTeamDTO);

        TeamDTO result = teamService.updateTeam(1L, updateTeamDTO);

        assertNotNull(result);
        verify(teamRepository).findById(1L);
        verify(teamMapper).updateTeamFromDto(updateTeamDTO, mockTeam);
        verify(teamRepository).save(mockTeam);
        verify(teamMapper).toDTO(updatedTeam);
    }

    @Test
    public void testDeleteTeamById_Success() {
        when(teamRepository.existsById(1L)).thenReturn(true);

        teamService.deleteTeamById(1L);

        verify(teamRepository).existsById(1L);
        verify(teamRepository).deleteById(1L);
    }

    @Test
    public void testDeleteTeamById_NotFound() {
        when(teamRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> teamService.deleteTeamById(1L));
        assertEquals("Le team avec l'ID 1 n'existe pas.", exception.getMessage());

        verify(teamRepository).existsById(1L);
        verify(teamRepository, never()).deleteById(anyLong());
    }
}
