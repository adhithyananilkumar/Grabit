import React, { useState } from 'react';

function RestaurantForm({ initial, onSubmit }) {
  const [name, setName] = useState(initial?.name || '');
  const [location, setLocation] = useState(initial?.location || '');
  const [type, setType] = useState(initial?.type || '');

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit({ name, location, type });
    setName('');
    setLocation('');
    setType('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <h3>{initial ? 'Edit' : 'Add'} Restaurant</h3>
      <input placeholder="Name" value={name} onChange={e => setName(e.target.value)} required />
      <input placeholder="Location" value={location} onChange={e => setLocation(e.target.value)} required />
      <input placeholder="Type" value={type} onChange={e => setType(e.target.value)} required />
      <button type="submit">{initial ? 'Update' : 'Add'}</button>
    </form>
  );
}

export default RestaurantForm;
